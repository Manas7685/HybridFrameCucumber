package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.Keyword;

public class MyAccountPage {
	
	
	@FindBy(css="\"#post-8 > header > h1\"")
	WebElement heading;
	
	@FindBy(css="\"#post-8 > div > div > nav > ul>li")
	List<WebElement> accSections;
	
	
	
	
	 public MyAccountPage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	 
	 public String getPageHeading() {
		 return Keyword.getTextOf(heading);
	 }
		 
		 
		 	

		 	
		 	
		 	public String getAccountsPageTitle() {
		 		return Keyword.getPageTitle();
		 	}

		 	public int getAccountsSectionCount() {
		 		return accSections.size();
		 	}

		 	public List<String> getAccountsSectionsList() {

		 		List<String> accountsList = new ArrayList<>();
		 		

		 		for (WebElement e : accSections) {
		 			String text = e.getText();
		 			System.out.println(text);
		 			accountsList.add(text);
		 		}

		 		return accountsList;

		 	}

		 }

		
	   


