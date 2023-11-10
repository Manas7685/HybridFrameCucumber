package com.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.MyAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
	
	HomePage homepage = new HomePage();
	LoginPage loginpage=new LoginPage();
	
	MyAccountPage accPage= new MyAccountPage();
	String title;
	boolean status;
	private static Logger logger = Logger.getLogger(LoginPageStepDef .class);

	@Given("User navigates to login page")
public void user_is_on_login_page() {
   homepage.clickOnMyAccountMenu();
}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
    title=loginpage.getLoginPageTitle();
}

@Then("page title should contains {string}")
public void page_title_should_contains(String string) {
	try {
		Assert.assertEquals(title.contains(string), true);
		logger.info("********** TC001 : Validate My Account Page : Passed **********");
	} catch (Exception e) {
		logger.error("********** TC001 : Validate My Account Page  : Failed **********\n" + e);
	}
    
}

@Then("forgot your password link should be displayed")
public void forgot_your_password_link_should_be_displayed() {
   status=loginpage.isForgotPwdLinkExist();
   try {
		Assert.assertEquals(status, true);
		logger.info("********** TC001 : Validate Forgot Password Link : Passed **********");
	} catch (Exception e) {
		logger.error("********** TC001 : Validate Forgot Password Link  : Failed **********\n" + e);
	}
   
   
}

@When("User enters valid email address {string} into email field")
public void user_enters_valid_email_address_into_email_field(String email) {
    loginpage.enterEmailAddress("email");
}
@When("User enters valid password {string} into password field")
public void user_enters_valid_password_into_password_field(String passwd) {
    loginpage.enterPassword("passwd");
}

@When("User clicks on Login button")
public void user_clicks_on_login_button() {
    loginpage.clickOnLoginButton();
}

@Then("User should get successfully logged in")
public void user_should_get_successfully_logged_in() {
	try
	{
		Assert.assertEquals(accPage.getPageHeading().equalsIgnoreCase("My account"),true);
		logger.info("********** TC006 : Validate MyAccount Page : Passed **********");
	}
	catch(Exception e)
	{
		logger.error("********** TC006 : Validate MyAccount Page : Failed **********");
	}
    
}

@When("User enters invalid email address into email field")
public void user_enters_invalid_email_address_into_email_field() {
	loginpage.enterEmailAddress();
}

@When("User enters invalid password {string} into password field")
public void user_enters_invalid_password_into_password_field(String string) {
    loginpage.enterPassword("abcd");
}

@Then("User should get a proper warning message about credentials mismatch")
public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	String error=loginpage.getWarningMessageText();
	try
	{
		Assert.assertEquals(error.contains("Error:"),true);
		logger.info("********** TC006 : Validate Credentials-Mismatch : Passed **********");
	}
	catch(Exception e)
	{
		logger.error("********** TC006 : Validate Credentials-Mismatch  **********");
	}
	
   
}


@When("User dont enter email address into email field")
public void user_dont_enter_email_address_into_email_field() {
    loginpage.enterEmailAddress();
}

@When("User dont enter password into password field")
public void user_dont_enter_password_into_password_field() {
   loginpage.enterPassword("");
}


}
