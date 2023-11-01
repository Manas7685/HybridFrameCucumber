package com.stepdefinitions;

import org.testng.Assert;


import com.pageobjects.HomePage;
import com.utility.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {
	HomePage homepage=new HomePage();
	
	@Given("User nevigate to homepage")
	public void user_nevigate_to_homepage() {
		homepage.initTestWithHomepage();
	   
	}

	@When("user clicks on Blog menu")
	public void user_clicks_on_blog_menu() {
		homepage.clickOnBlogMenu();
	    
	}

	@Then("blog page should display")
	public void blog_page_should_display() {
		System.out.println(Keyword.getCurrURL());
	    Assert.assertEquals(Keyword.getCurrURL().contains("/blog/"), true);
	}
	
	 @And("user clicks on home menu")
	    public void user_clicks_on_home_menu() {
	       homepage.clickOnHomeLink();
	 }
	       @Then("home page should display")
		    public void home_page_should_display() {
		        // Write code here that turns the phrase above into concrete actions
		        throw new io.cucumber.java.PendingException();
		    }
	@When("user clicks on Promotions menu")
	public void user_clicks_on_Promotions_menu() {
		homepage.clickOnPromotionsMenu();;
	    
	}

	@Then("Promotions page should display")
	public void Promotions_page_should_display() {
	    Assert.assertEquals(Keyword.getCurrURL().contains("/welcome/"), true);
	    
	   

	   



	}




}
