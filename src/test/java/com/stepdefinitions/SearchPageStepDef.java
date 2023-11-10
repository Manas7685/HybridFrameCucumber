package com.stepdefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.frmbase.BaseClass;
import com.pageobjects.BlogPage;
import com.pageobjects.CartPage;
import com.pageobjects.CheckoutPage;
import com.pageobjects.ContactPage;
import com.pageobjects.HomePage;
import com.pageobjects.MyAccountPage;
import com.pageobjects.PromotionPage;
import com.pageobjects.SearchResultPage;
import com.utility.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDef {
    HomePage homepage = new HomePage();
    SearchResultPage searchPage = new SearchResultPage();

    private static Logger logger = Logger.getLogger(SearchPageStepDef.class);

    @When("User enters valid product {string} into Search box field")
    public void user_enters_valid_product_into_search_box_field(String string) {
   	 searchPage.enterProduct(string);
   	 
    }

    @When("User hits enter key")
    public void user_hits_enter_key() {
   	 searchPage = searchPage.hitEnter();
    }

    @Then("User should get valid products displayed on page")
    public void user_should_get_valid_products_displayed_on_page() throws Throwable {
   	 
   	 List<String> titles=searchPage.getProductTitles();
   	 for(String title:titles)
   	 {
   		 
   		 Assert.assertTrue(title.contains("Falcon"));
   	 }
    }

    @When("User enters invalid product {string} into Search box field")
    public void user_enters_invalid_product_into_search_box_field(String string) {
   	 searchPage.enterProduct(string);

    }

    @Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
   	 String msg = searchPage.getWarningMessageText();
   	 Assert.assertEquals(msg.equalsIgnoreCase("No products were found matching your selection."), true);
    }

    @When("User dont enter any product name into Search box field")
    public void user_dont_enter_any_product_name_into_search_box_field() {
   	 searchPage.enterProduct("");
    }
}
