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
import com.utility.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDef {
	HomePage homepage = new HomePage();
	CartPage cartpage = new CartPage();
	CheckoutPage checkoutpage = new CheckoutPage();
	PromotionPage pro = new PromotionPage();
	MyAccountPage myAcc = new MyAccountPage();
	BlogPage blog = new BlogPage();
	ContactPage contact = new ContactPage();
	
	private static Logger logger = Logger.getLogger(HomePageStepDef .class);


	@Given("User nevigate to homepage")
	public void user_nevigate_to_homepage() {
		homepage.initTestWithHomepage();

	}

	@When("user clicks on Blog menu")
	public void user_clicks_on_blog_menu() {
		blog = homepage.clickOnBlogMenu();

	}

	@Then("blog page should display")
	public void blog_page_should_display() {
		System.out.println(Keyword.getCurrURL());
		Assert.assertEquals(blog.getPageUrl().contains("/blog/"), true);
	}

	@And("user clicks on home menu")
	public void user_clicks_on_home_menu() {
		homepage = homepage.clickOnHomeLink();
		logger .info("*********** Clicking on home menu... **********");
	}

	@Then("home page should display")
	public void home_page_should_display() {
		Assert.assertEquals(homepage.getPageUrl().equalsIgnoreCase("https://demos.bellatrix.solutions"), true);
	}
	

	@When("user clicks on cart menu")
	public void user_clicks_on_cart_menu() {
		homepage.clickOnCartMenu();
		
	}
	
	

	
	@Then("Cart page should display.")
	public void Cart_page_should_display()
	{
		System.out.println("URL : "+cartpage.getPageUrl());
		Assert.assertEquals(cartpage.getPageUrl().contains("cart"), true);
	}

	@When("user clicks on Promotions menu")
	public void user_clicks_on_Promotions_menu() {
		pro = homepage.clickOnPromotionsMenu();
		;

	}

	@Then("Promotions page should display")
	public void Promotions_page_should_display() {
		Assert.assertEquals(pro.getPageUrl().contains("/welcome/"), true);
	}

	@Then("logo should be visible on page")
	public void logo_is_visible_on_page() {
		try {
			Assert.assertEquals(homepage.validateLogo(), true);
			logger.info("********** TC001 : Validate Logo : Passed **********");
		} catch (Exception e) {
			logger.error("********** TC001 : Validate Logo : Failed **********",e);
		}

	}

	@When("user clicks on logo")
	public void user_clicks_on_logo() {
		homepage = homepage.clickOnBellatrixLogo();
	}

	@Then("home page should get refreshed")
	public void home_page_should_get_refreshed() {
		try {
			String actual = "https://demos.bellatrix.solutions/";
			String expected = homepage.getPageUrl();
			Assert.assertEquals(actual, expected);
			logger.info("********** TC002 : Page get refreshed : Passed **********");
		} catch (Exception e) {
			logger .error("********** TC002 : Page get refreshed : Failed **********\n", e);
		}

	}

	@When("user clicks on checkout menu")
	public void user_clicks_on_checkout_menu() {
		checkoutpage = homepage.clickOnCheckoutMenu();
	}

	@When("cart is not empty")
	public boolean cart_is_not_empty() {
		return homepage.isCartEmpty();

	}

	@Then("user should get checkout page.")
	public void user_should_get_checkout_page() {
		homepage=homepage.addToCart();
		checkoutpage = homepage.clickOnCheckoutMenu();
		
		if (!homepage.isCartEmpty()) {
			String str = checkoutpage.getHeadingOfCheckoutPage();
			//String actual = checkoutpage.getPageUrl();

			try {
				//Assert.assertEquals(actual.contains("/checkout/"), true);
				Assert.assertEquals(str.contains("Checkout"), true);
				logger.info("********** TC004 : ValidateCheckOutOnNonEmptyCart : Passed **********");
			} catch (Exception e) {
				logger
						.error("********** TC004 : ValidateCheckOutOnNonEmptyCart : failed **********\n", e);
			}

		}

	}

	@When("cart is empty")
	public boolean cart_is_empty() {
		return homepage.isCartEmpty();
	}

	@Then("user should get cart page with proper waring message {string}.")
	public void user_should_get_cart_page_with_proper_waring_message(String s1) {
		checkoutpage=homepage.clickOnCheckoutMenu();
		if (homepage.isCartEmpty()) {
			
			String actual =checkoutpage.getPageUrl();

			try {

				Assert.assertEquals(actual.contains("/cart/"), true);
				String str = checkoutpage.getMessage();
				System.out.println("------------------");
				System.out.println(str);
				System.out.println("------------------");
				//Assert.assertEquals(str.contains(s1), true);
				logger.info("********** TC003 : ValidateCheckOutOnEmptyCart : Passed **********");
			} catch (Exception e) {
				logger.error("********** TC003 : ValidateCheckOutOnEmptyCart : failed **********\n" , e);
			}

		}
	}

	@When("user hover on cart symbol")
	public void user_hover_on_cart_symbol() {
		homepage.mouseHoverOnCartSymbol();
	}

	@Then("{string} should display as a tool tip")
	public void should_display_as_a_tool_tip(String ttip) {
		String s1 = homepage.getToolTip();
		try {
			Assert.assertEquals(s1.equalsIgnoreCase(ttip), true);
			logger.info("********** TC005 : ValidateToolTipOfCartSymbol : Passed **********");
		} catch (Exception e) {
			logger.error("********** TC005 : ValidateToolTipOfCartSymbol : failed **********\n", e);

		}

	}

	@Then("no mini cart view displayed.")
	public void no_mini_cart_view_displayed_when_hover_on_cart_symbol() {
		boolean cartView=false;
		if(homepage.isCartEmpty())
		{
			homepage.mouseHoverOnCartSymbol();
			if(homepage.isMinicartViewDisplayed()==null)
			cartView=false;			
		}
		try {
			Assert.assertEquals(cartView, false);
			logger.info("********** TC007 : ValidateMinicartView : Passed **********");
		} catch (Exception e) {
			logger.error("********** TC007 : ValidateMinicartView : failed **********\n",e);

		}
		
		
	}
	
	@Then("{string} should display as popup.")
	public void display_Popup_As(String str)
	{
		
		String pop="";
		if(homepage.isCartEmpty())
		{
			homepage.mouseHoverOnCartSymbol();
			pop=homepage.getTextOfPopup();			
		}
		try {
			Assert.assertEquals(pop.equalsIgnoreCase(str), true);
			logger.info("********** TC006 : ValidateCartSymbolPopup : Passed **********");
		} catch (Exception e) {
			logger.error("********** TC006 : ValidateCartSymbolPopup : failed **********\n",e);

		}
		
	}

	@Then("mini cart view should displayed.")
	public void mini_cart_view_should_displayed_when_hover_on_cart_symbol() {
		boolean cartView=false;
		homepage=homepage.addToCart();
		homepage.mouseHoverOnCartSymbol();
		if(!homepage.isCartEmpty())
		{
			
			if(homepage.isMinicartViewDisplayed()!=null)
				cartView=true;		
			
		}
		try {
			Assert.assertEquals(cartView, true);
			logger.info("********** TC006 : ValidateMinicartView : Passed **********");
		} catch (Exception e) {
			logger.error("********** TC006 : ValidateMinicartView : failed **********\n",e);

		}
	}
		
		
		@Then("Dropdown option should display to sort product.")
		public void dropdown_option_should_display_to_sort_product() {
			
			boolean ddPresent=false;
			if(homepage.isDropdownDisplayed()!=null)
				ddPresent=true;	
			try {
				Assert.assertEquals(ddPresent, true);
				logger.info("********** TC006 : ValidateDropdown : Passed **********");
			} catch (Exception e) {
				logger.error("********** TC006 : ValidateDropdown : failed **********\n" ,e);

			}
		}
		
		
		
		@When("user clicks on dropdown")
		public void user_clicks_on_it() {
		    homepage.clickDropdown();
		}
		@Then("Dropdown should display {string}")
		public void dropdown_should_display_opt1(String option) {
			List<WebElement> lst=homepage.getOptionsListOfDropdown();

	       
	        System.out.println("The dropdown options are:");
	        boolean isThere=false;
	        for(WebElement options: lst)
	        {
	            String opt=options.getText();
	            if(opt.equalsIgnoreCase(option))
	            {
	            
	            	isThere=true;
	            	break;
	            }
	            
	            
	        }
	        try {
				Assert.assertEquals(isThere, true);
				logger.info("********** TC006 : ValidateDropdownOptions : Passed **********");
			} catch (Exception e) {
				logger.error("********** TC006 : ValidateDropdownOptions : failed **********\n",e);
			}

	        

		}
		
		
		@When("select any option")
		public void select_any_option() {
		    homepage.selectOption("Sort by latest");
		}
		@Then("user should get page with sorted products.")
		public void user_should_get_page_with_sorted_products() {
			String actual =BaseClass.getDriver().getCurrentUrl();

			try {

				Assert.assertEquals(actual.contains("?orderby="), true);
				logger.info("********** TC003 : ValidateOredrByPage : Passed **********");
			} catch (Exception e) {
				logger.error("********** TC003 : ValidateOredrByPage : failed **********\n",e);
			}
		    
		}

		
		@When("user select {string} from dropdown")
		public void user_select_from_dropdown(String option) {
			homepage.selectOption(option);
		    
		}
		@Then("products should displayed in sorted order: low to high price")
		public void products_should_displayed_in_sorted_order_low_to_high_price() {
		   String option=homepage.getSelectedOption();
		   if(option!=null)
		   {
			   List<WebElement> lst=homepage.getPricesOfAllProducts();
			   
			   List<Double> prices = new ArrayList<Double>();
			   for (WebElement e : lst)
			   {
				   String str[]=e.getText().split("€");
				   String s=str[0].replaceAll(",","");
			       prices.add(Double.parseDouble(s));
			   }

			  
			   List<Double> sortedPrices = new ArrayList<Double>(prices);

			 
			   Collections.sort(sortedPrices);
			  

			  
			   try {
					Assert.assertEquals(sortedPrices.equals(prices), true);
					logger.info("********** TC006 : ValidateDropdownOptions Low to high : Passed **********");
				} catch (Exception e) {
					logger.error("********** TC006 : ValidateDropdownOptions Low to high : failed **********\n",e);
				}

			  
			   
		   }
		}
		
		@Then("products should displayed in sorted order: high to low price")
		public void products_should_displayed_in_sorted_order_high_to_low_price() {
			String option=homepage.getSelectedOption();
			   if(option!=null)
			   {
				   List<WebElement> lst=homepage.getPricesOfAllProducts();
				   
				   List<Double> prices = new ArrayList<Double>();
				   
				   for (WebElement e : lst)
				   {
					   String str[]=e.getText().split("€");
					   String s=str[0].replaceAll(",","");
				       prices.add(Double.parseDouble(s));
				   }
				   Object sortedPrices[]=prices.toArray();
				   Arrays.sort(sortedPrices,Collections.reverseOrder());
				   			  
				   try {
						Assert.assertEquals(sortedPrices.equals(prices), true);
						logger.info("********** TC006 : ValidateDropdownOptions Low to high : Passed **********");
					} catch (Exception e) {
						logger.error("********** TC006 : ValidateDropdownOptions Low to high : failed **********\n",e);
					}

				  
				   
			   }
		}


		
		
	}

	