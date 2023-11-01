package com.frmbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks {

	public static RemoteWebDriver driver;
	private BaseClass base;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		
		prop = ConfigReader.configProperties();
	}

	@Before(order = 1)
	public void launchBrowser() {
		//String browserName = prop.getProperty("browser");
		base= new BaseClass();
		driver = base.initializeDriver(prop.getProperty("browser"));
		
	}


	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	

}
