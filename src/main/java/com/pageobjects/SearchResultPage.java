package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frmbase.BaseClass;
import com.utility.Keyword;

public class SearchResultPage {

    public SearchResultPage() {
   	 PageFactory.initElements(BaseClass.getDriver(), this);
    }

    @FindBy(css = "#woocommerce-product-search-field-0")
    private WebElement searchbox;

    @FindBy(css =".woocommerce-info")
    private WebElement message;
    
    @FindBy(css = "#main > ul > li> a > h2")
    private List<WebElement> productTitle;

    
    
    
    
    
    
    public void enterProduct(String s) {

   	 Keyword.sendText(searchbox, s);

    }

    public List<String> getProductTitles() throws Throwable
    {
   	 
   	 Keyword.scrollWindow();
   	 List<String> productTitles=new ArrayList<String>();
   	 
   	 for(WebElement prod_title:productTitle)
   	 {
   		 
   		 productTitles.add(prod_title.getText());
   	 }    
   	 return productTitles;
    }


    public String getWarningMessageText() {

   	 return Keyword.getTextOf(message);
    }

    public SearchResultPage hitEnter() {
   	  Keyword.sendKeys(searchbox,Keys.RETURN);
   	  return new SearchResultPage();
    }

}
