package com.frmbase;



import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utility.ConfigReader;




public class BaseClass {

	private static RemoteWebDriver driver;
	private static Logger logger = Logger.getLogger(BaseClass.class);

	
	public RemoteWebDriver initializeDriver(String browser) throws MalformedURLException {

		System.out.println("browser value is: " + browser);
		logger=Logger.getLogger("HybridCucumber");
		
		if (ConfigReader.configProperties().getProperty("execution_mode").equalsIgnoreCase("local")) {
			logger.info("Executing suite on local");

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
		}
		
		 else {
				logger.info("Executing suite on grid");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability("se:name", "My simple test");
				firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");

				driver = new RemoteWebDriver(new URL("http://192.168.0.115:4444"), firefoxOptions);
			}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	
public static RemoteWebDriver getDriver() {
		
		return driver;
	}


}
