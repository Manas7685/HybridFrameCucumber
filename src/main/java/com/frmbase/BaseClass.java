package com.frmbase;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;




public class BaseClass {

	public static RemoteWebDriver driver;
	public RemoteWebDriver initializeDriver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		} else {
			System.out.println("Please pass the valid browser value: " + browser);
			System.exit(1);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	
public static RemoteWebDriver getDriver() {
		
		return driver;
	}

}
