package com.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.Keyword;

public class PromotionPage {
	
	public PromotionPage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	
	public String getPageUrl()
	{
		return Keyword.getCurrURL();
	}
	

}
