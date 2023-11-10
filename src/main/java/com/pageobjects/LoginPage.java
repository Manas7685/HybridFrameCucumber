package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.CommonUtils;
import com.utility.Keyword;


public class LoginPage {
	

	@FindBy(css="#content > div > div.woocommerce > ul > li:nth-child(1) > strong:nth-child(1)")
	
	WebElement errorMsg;
	
	@FindBy(css="#username")
	WebElement emailField;
	
	@FindBy(css="#password")
	WebElement passwordField;
	
	@FindBy(css="#post-8 > div > div > form > p:nth-child(3) > button")
	WebElement loginButton;
	
	@FindBy(css="a[href='https://demos.bellatrix.solutions/my-account/lost-password/']")
	WebElement forgotPwdLink;
	
	
	
	 public LoginPage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	
	
	public void enterEmailAddress(String emailText) {
		
		Keyword.sendText(emailField, emailText);
		
	}
	public void enterEmailAddress() {
		
		Keyword.sendText(emailField, CommonUtils.getEmailWithTimeStamp());
		
	}
	
	public void enterPassword(String passwordText) {
		
		Keyword.sendText(passwordField, passwordText);		
	}
	
	public MyAccountPage clickOnLoginButton() {
		
		Keyword.clickOn(loginButton);
		return new MyAccountPage();
		
	}
	
	public String getWarningMessageText() {
		
		return Keyword.getTextOf(errorMsg);		
	}
	
	
	public String getLoginPageTitle() {
		return Keyword.getPageTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return Keyword.isDisplayed(forgotPwdLink);
	}

	public void enterUserName(String username) {
		Keyword.sendText(emailField,username);
	}

}