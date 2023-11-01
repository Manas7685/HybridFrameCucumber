package com.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import com.frmbase.MyHooks;

import java.time.Duration;

public class Keyword {
	
	public static void launchURL(String url ){
		System.out.println(url);
		MyHooks.driver.get(url);
		Keyword.maximizeWindow(MyHooks.driver);
		}
	
	public static void maximizeWindow(RemoteWebDriver driver ){
		MyHooks.driver.manage().window().maximize();
	}
	
	public static void implicitWait(RemoteWebDriver driver, int timeOut) {
		MyHooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public static void explicitWait(RemoteWebDriver driver, WebElement element, int timeOut )
	{		
		Wait wait = new FluentWait(MyHooks.driver).withTimeout(Duration.ofSeconds(timeOut));
		//wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeOut(RemoteWebDriver driver, int timeOut) {
		MyHooks.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	
	public static void scrollByVisibilityOfElement(WebElement ele) {
		
		MyHooks.driver.executeScript("arguments[0].scrollIntoView();", ele);

	}
	
	public static boolean findElementOnPage(WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			System.out.println("Location not found: "+ele);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}
	
	public static boolean sendText(WebElement elt,String textToSend) {
		boolean flag = false;
		try {
			flag = elt.isDisplayed();
			elt.clear();
			elt.sendKeys(textToSend);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}
	
	public static boolean selectBySendkeys(WebElement elt,String valueToSend) {
		boolean flag = false;
		try {
			elt.sendKeys(valueToSend);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}
	
	public static void ClickOn(WebElement elt)
	{
		elt.click();
	}
	
	public static void MoveAndclickOn(WebElement ele) {

		Actions act = new Actions(MyHooks.driver);
		act.moveToElement(ele).click().build().perform();

	}
	public static void mouseHover(WebElement ele) {

		Actions act = new Actions(MyHooks.driver);
		act.moveToElement(ele).perform();

	}
	
	public static boolean isDisplayed(WebElement ele) {
		boolean flag = false;
		flag = findElementOnPage(ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	public static String getPageTitle() {
		return MyHooks.driver.getTitle();
		
	}

	
	public static String getCurrURL() {
		String text = MyHooks.driver.getCurrentUrl();
		
			System.out.println("Current URL is: \""+text+"\"");
			return text;
	}

	public static void scrollWindow() {
		MyHooks.driver.executeScript("window.scrollBy(0,500);");
		
	}

	public static void nevigateToHomePage() {
		MyHooks.driver.navigate().to(ConfigReader.configProperties().getProperty("url"));
		
	}

	public static void waitUntilPageLoadsCompletely() {
		implicitWait(MyHooks.driver, 100);
	}

	
	
	
}

	
	/*
void clickOn(String locatorType, String locatorValue) {
		
		locatorType=locatorType.toLowerCase();
		
		switch(locatorType)
		{
		case "id":
			driver.findElement(By.id(locatorValue)).click();
			break;
		case "class":
			driver.findElement(By.className(locatorValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).click();
			break;
		case "css" : 
			driver.findElement(By.cssSelector(locatorValue)).click();
			break;
		default:
			System.err.println("Invalid Locator Type.........");
		}

		}
	
void sendText(String locatorType, String locatorValue, String textToSend) {
	
	locatorType=locatorType.toLowerCase();
	
	switch(locatorType)
	{
	case "id":
		driver.findElement(By.id(locatorValue)).sendKeys(textToSend);
		break;
	case "class":
		driver.findElement(By.className(locatorValue)).sendKeys(textToSend);
		break;
	case "xpath":
		driver.findElement(By.xpath(locatorValue)).sendKeys(textToSend);
		break;
	case "css" : 
		driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToSend);
		break;
	default:
		System.err.println("Invalid Locator Type.........");
		
	
	}

	}
	
*/
