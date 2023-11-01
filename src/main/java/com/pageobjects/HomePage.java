package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frmbase.BaseClass;
import com.frmbase.MyHooks;
import com.utility.ConfigReader;
import com.utility.Keyword;

import io.cucumber.java.BeforeStep;

public class HomePage 
{
	
	@FindBy(css = "a.cart-contents")
	private WebElement cartSymbol;

	@FindBy(css = "a[href='?add-to-cart=28']")
	private WebElement addToCartButton1;

	@FindBy(css = "a[href='?add-to-cart=12']")
	private WebElement addToCartButton2;

	@FindBy(css = "a[href='?add-to-cart=26']")
	private WebElement addToCartButton3;

	@FindBy(css = "a[href='?add-to-cart=31']")
	private WebElement addToCartButton4;

	@FindBy(css = "a.custom-logo-link")
	private WebElement bellatrixLogo;

	@FindBy(css = "div:nth-child(2) > ul > li.current_page_item > a")
	private WebElement homeMenu;

	@FindBy(css = "div:nth-child(2) > ul > li.page_item.page-item-17 > a")
	private WebElement blogMenu;

	@FindBy(css = "div:nth-child(2) > ul > li.page_item.page-item-6 > a")
	private WebElement cartMenu;

	@FindBy(css = "div:nth-child(2) > ul > li.page_item.page-item-7 > a")
	private WebElement checkoutMenu;

	@FindBy(css = "div:nth-child(2) > ul > li.page_item.page-item-3342 > a")
	private WebElement contactFormMenu;
	
	@FindBy(css = "div:nth-child(2) > ul > li.page_item.page-item-8 > a")
	private WebElement myAccountMenu;

	
	@FindBy(css="div:nth-child(2) > ul > li.page_item.page-item-16> a")
	private WebElement promotionsMenu;
	
	@FindBy(css = "div > div.site-info > a")
	private WebElement goToWoocommerce;

	@FindBy(css = "a[href='https://demos.bellatrix.solutions/product/proton-rocket/']")
	
	private WebElement protonRocketSale650000000450000000;

	@FindBy(css = "#main ul.products.columns-4 li:nth-of-type(3) a:nth-of-type(1)")
	
	private WebElement protonm1500;

	@FindBy(css = "#main ul.products.columns-4 li:nth-of-type(3) a:nth-of-type(2)")
	
	private WebElement readMore;

	@FindBy(css = "a[href='https://demos.bellatrix.solutions/product/saturn-v/']")
	
	private WebElement saturnVSale1430012000;

	@FindBy(css = "#woocommerce-product-search-field-0")
	private WebElement searchBar;
	
	@FindBy(name = "orderbydiv:nth-child(2) > form > select")
	
	private WebElement orderRelevanceDropdown1;

	@FindBy(name = "#main > div:nth-child(4) > form > select")
	
	private WebElement orderRelevanceDropdown2;
	
	  public void initTestWithHomepage() 
	   {
		    Keyword.nevigateToHomePage();
	        Keyword.pageLoadTimeOut(BaseClass.getDriver(),Integer.parseInt(ConfigReader.configProperties().getProperty("pageLoadTimeOut")));
	    }

	   
	   public HomePage() 
	   {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}
	   
	   public boolean validateLogo()
	   {
		   return Keyword.isDisplayed(bellatrixLogo);
	   }
		
	   public HomePage clickOnBellatrixLogo() {
		   bellatrixLogo.click();
			return this;
		}
	   
	   public HomePage clickOnBlogMenu() {
			blogMenu.click();
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	   public HomePage clickOnCartMenu() {
			blogMenu.click();
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	   
	   public HomePage clickOnCheckoutMenu() {
		   checkoutMenu.click();
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	   
	   public HomePage clickOnContactFormMenu() {
			contactFormMenu.click();
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	   
	   public HomePage clickOnMyAccountMenu() {
			myAccountMenu.click();
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	  
	    public HomePage clickOnPromotionsMenu() 
	    {
	      
	        promotionsMenu.click();
	        Keyword.waitUntilPageLoadsCompletely();
			return this;
	        
	    }

	   
	    public HomePage clickOnBuiltWithStorefrontWoocommerceLink() {
	    	goToWoocommerce.click();
			return this;
		}
}
/**
 * 
 

	   
	/*public HomePage clickCart0Link() {
		cart0.click();
		return this;
	}

	
	public HomePage clickCart1Link() {
		cart1.click();
		return this;
	}

	
	public HomePage clickCart2Link() {
		cart2.click();
		return this;
	}
*/
	


	

	
	
	

	

	
	/**
	public BellaTrixHomePage clickProtonRocketSale650000000450000000Link() {
		protonRocketSale650000000450000000.click();
		return this;
	}

	/**
	 * Click on Protonm 15.00 Link.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage clickProtonm1500Link() {
		protonm1500.click();
		return this;
	}

	/**
	 * Click on Read More Link.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage clickReadMoreLink() {
		readMore.click();
		return this;
	}

	/**
	 * Click on Saturn V Sale 143.00 120.00 Link.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage clickSaturnVSale1430012000Link() {
		saturnVSale1430012000.click();
		return this;
	}

	

	

	

	/**
	 * Fill every fields in the page.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage fill() {
		setSearchFor1DropDownListField();
		setSearchFor2DropDownListField();
		setSearchFor3DropDownListField();
		setSearchFor4SearchField();
		setSearchFor5TextareaField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor1DropDownListField() {
		return setSearchFor1DropDownListField(data.get("SEARCH_FOR_1"));
	}

	/**
	 * Set value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor1DropDownListField(String searchFor1Value) {
		searchFor1.sendKeys(searchFor1Value);
		return this;
	}

	/**
	 * Set default value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor2DropDownListField() {
		return setSearchFor2DropDownListField(data.get("SEARCH_FOR_2"));
	}

	/**
	 * Set value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor2DropDownListField(String searchFor2Value) {
		new Select(searchFor2).selectByVisibleText(searchFor2Value);
		return this;
	}

	/**
	 * Set default value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor3DropDownListField() {
		return setSearchFor3DropDownListField(data.get("SEARCH_FOR_3"));
	}

	/**
	 * Set value to Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor3DropDownListField(String searchFor3Value) {
		new Select(searchFor3).selectByVisibleText(searchFor3Value);
		return this;
	}

	/**
	 * Set default value to Search For Search field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor4SearchField() {
		return setSearchFor4SearchField(data.get("SEARCH_FOR_4"));
	}

	/**
	 * Set value to Search For Search field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor4SearchField(String searchFor4Value) {
		searchFor4.sendKeys(searchFor4Value);
		return this;
	}

	/**
	 * Set default value to Search For Textarea field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor5TextareaField() {
		return setSearchFor5TextareaField(data.get("SEARCH_FOR_5"));
	}

	/**
	 * Set value to Search For Textarea field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage setSearchFor5TextareaField(String searchFor5Value) {
		searchFor5.sendKeys(searchFor5Value);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage submit() {
		clickSearchButton();
		return this;
	}

	/**
	 * Unset default value from Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage unsetSearchFor2DropDownListField() {
		return unsetSearchFor2DropDownListField(data.get("SEARCH_FOR_2"));
	}

	/**
	 * Unset value from Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage unsetSearchFor2DropDownListField(String searchFor2Value) {
		new Select(searchFor2).deselectByVisibleText(searchFor2Value);
		return this;
	}

	/**
	 * Unset default value from Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage unsetSearchFor3DropDownListField() {
		return unsetSearchFor3DropDownListField(data.get("SEARCH_FOR_3"));
	}

	/**
	 * Unset value from Search For Drop Down List field.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage unsetSearchFor3DropDownListField(String searchFor3Value) {
		new Select(searchFor3).deselectByVisibleText(searchFor3Value);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public BellaTrixHomePage verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the BellaTrixHomePage class instance.
	 
	public HomePage verifyPageUrl() {
		(new WebDriverWait(BaseClass.getDriver(), timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}

*/