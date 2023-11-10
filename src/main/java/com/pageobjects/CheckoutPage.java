package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.Keyword;

public class CheckoutPage {
	
	
	@FindBy(css="header > h1")
	WebElement header;
	@FindBy(css="#post-6 > div > div > p.cart-empty.woocommerce-info")
	WebElement firstMsg;
	
	
	  public CheckoutPage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	  
	  public String getHeadingOfCheckoutPage()
	  {
		  
			  return Keyword.getTextOf(header);
		 
	  }
	  public String getPageUrl()
		{
			return Keyword.getCurrURL();
		}
	  
	  public String getMessage()
	  {
		  
			  return Keyword.getTextOf(firstMsg);
		 
	  }
	   
	  
	  
	
	

}
