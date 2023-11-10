package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.frmbase.BaseClass;

import com.utility.ConfigReader;
import com.utility.Keyword;

public class HomePage 
{
	
	@FindBy(css = "#site-header-cart > li:nth-child(1) > a")
	private WebElement cartSymbol;
	
	//#site-header-cart > li:nth-child(1) > a
	
	@FindBy(css="li:nth-child(2) > div > div > p")
	private WebElement cartSymbolpopup;
	
	
	
	@FindBy(css="li:nth-child(2) > div > div > p.woocommerce-mini-cart__total.total > strong")
	WebElement minicart;
	
	
	@FindBy(css="#site-header-cart > li:nth-child(2) > div > div")
	WebElement minicartview;
	
	
	
	@FindBy(css="#site-header-cart li:nth-child(2) > div > div > p.woocommerce-mini-cart__buttons.buttons > a:nth-child(1)")
	private WebElement viewcartOnMiniCartView;

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
	
	@FindBy(css="#site-header-cart > li:nth-child(2) > div > div > p.woocommerce-mini-cart__buttons.buttons > a:nth-child(2)")
	private WebElement checkoutOnMiniCartView;

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
	
	@FindBy(css="#site-header-cart > li:nth-child(1) > a > span.count")
	WebElement numberOfCartItems;
	
	@FindBy(css="#site-header-cart > li:nth-child(1) > a > span.woocommerce-Price-amount.amount")
	WebElement cartAmount;

	@FindBy(css = "#woocommerce-product-search-field-0")
	private WebElement searchBar;
	
	@FindBy(css = "#main > div:nth-child(2) > form > select")
	
	private WebElement orderRelevanceDropdown1;

	@FindBy(css = "#main > div:nth-child(4) > form > select")
	
	private WebElement orderRelevanceDropdown2;
	
	@FindBy(css="ins>span[class*='woocommerce-Price-amount amount']>bdi")
	java.util.List<WebElement> allPrices;
	
	@FindBy(css="#main > ul > li.product.type-product.post-28.status-publish.first.onbackorder.product_cat-big-rockets.has-post-thumbnail.sale.downloadable.taxable.shipping-taxable.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
	WebElement falconAddToCart;
	
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
		  Keyword.clickOn(bellatrixLogo);
			return this;
		}
	   
	   public BlogPage clickOnBlogMenu() {
			Keyword.clickOn(blogMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return new BlogPage();
		}
	   public CartPage clickOnCartMenu() {
		   Keyword.clickOn(cartMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return new CartPage();
		}
	   
	   public CartPage clickOnCartButton() {
		   Keyword.clickOn(viewcartOnMiniCartView);
			Keyword.waitUntilPageLoadsCompletely();
			return new CartPage();
		}
	   
	   public CheckoutPage clickOnCheckoutMenu() {
		   Keyword.clickOn(checkoutMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return new CheckoutPage();
		}
	   
	   public CheckoutPage clickOnCheckoutButton() {
		   Keyword.clickOn(checkoutOnMiniCartView);
			Keyword.waitUntilPageLoadsCompletely();
			return new CheckoutPage();
		}
	   
	   public HomePage clickOnContactFormMenu() {
		   Keyword.clickOn(contactFormMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	   
	   public HomePage clickOnMyAccountMenu() {
		   Keyword.clickOn(myAccountMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
	  
	    public PromotionPage clickOnPromotionsMenu() 
	    {
	      
	    	Keyword.clickOn(promotionsMenu);
	        Keyword.waitUntilPageLoadsCompletely();
			return new PromotionPage();
	        
	    }

	   
	    public HomePage clickOnBuiltWithStorefrontWoocommerceLink() {
	    	Keyword.clickOn(goToWoocommerce);
			return this;
		}


		public HomePage clickOnHomeLink() {
			Keyword.clickOn(homeMenu);
			Keyword.waitUntilPageLoadsCompletely();
			return this;
			
		}
		
		public int getNumberOfItemsPresentInCart()
		{
			String number[]=Keyword.getTextOf(this.numberOfCartItems).split(" ");
			int numberOfCartItems=Integer.parseInt(number[0]);
			return numberOfCartItems;
		}
		
		public boolean isCartEmpty()
		{
			boolean status=false;
			int number=getNumberOfItemsPresentInCart();
			if(number==0)
				status=true;
			
			return status;
		}
		public int getAmountOfCart()
		{
			int amount=Integer.parseInt(Keyword.getTextOf(this.cartAmount));
			return amount;
		}
		
		public void mouseHoverOnCartSymbol()
		{
			
			Keyword.mouseHover(cartSymbol);
		}
		
		public CartPage clickOnCartSymbol()
		{
			Keyword.mouseHover(cartSymbol);
			return new CartPage();
		}
		
		public String getToolTip()
		{
			return Keyword.getTitleOf(cartSymbol);
		}
		
		public String getPageUrl()
		{
			return Keyword.getCurrURL();
		}
		
		public boolean isPopupDisplayed()
		{
			return Keyword.isDisplayed(cartSymbolpopup);
		}
		
		
		public WebElement isMinicartViewDisplayed()
		{
			return Keyword.waitForVisibilityOfElement(BaseClass.getDriver(),minicartview,30);
		}
		
		public boolean isMinicartViewDisplayedTotal()
		{
			return Keyword.isDisplayed(minicart);
		}
		
		public String getTextOfPopup()
		{
			return Keyword.getTextOf(cartSymbolpopup);
		}


		public Object isDropdownDisplayed() {
			
			return Keyword.isDisplayed(orderRelevanceDropdown1);
		}
		
		public void clickDropdown()
		{
			Keyword.moveAndclickOn(orderRelevanceDropdown1);
		}
		
		public java.util.List<WebElement> getOptionsListOfDropdown()
		{
			return Keyword.getOptionsOfDropdown(orderRelevanceDropdown1);
		}


		public void selectOption(String option) {
			Keyword.selectOptionInDropdown(orderRelevanceDropdown1, option, 30);
			
		}


		public String getSelectedOption() {
			
			Select select = new Select(orderRelevanceDropdown1);
			
			return Keyword.getTextOf(select.getFirstSelectedOption());
		}


		public java.util.List<WebElement> getPricesOfAllProducts() {
			return allPrices;
		}
		
		public HomePage addToCart()
		{
			Keyword.scrollWindow();
			Keyword.clickOn(falconAddToCart);
			Keyword.waitUntilPageLoadsCompletely();
			return this;
		}
		
		
		
		
}


	

	
	
	

	

	
	