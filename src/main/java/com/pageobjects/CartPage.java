package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.Keyword;

public class CartPage {
	
	
	@FindBy(css="#content > div > div.woocommerce > div")
	WebElement firstMsg;
	@FindBy(css="div > div > p.cart-empty.woocommerce-info")
	WebElement secondMsg;
	
	
	  public CartPage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	  
	  public String getMessageOfCartPage()
	  {
		  
			  return Keyword.getTextOf(firstMsg);
		 
	  }
	  
	  public String getPageUrl()
		{
			return Keyword.getCurrURL();
		}
	   
	
	

}
