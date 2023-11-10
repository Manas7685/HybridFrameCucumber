package com.frmbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


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
		try {
			driver = base.initializeDriver(prop.getProperty("browser"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
	}


	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String basePath=System.getProperty("user.dir");
			String screenshotName =new Date().toString().replace(" ","_").replace(":","_")+ scenario.getName().replaceAll(" ", "_");
			
			 AShot as = new AShot();
		Screenshot sc = as.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try
		{
		ImageIO.write(sc.getImage(), "png", new File(basePath+"/FailedTCScreenshot/"+screenshotName+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			 /**
			  * 
			 
			
			File source = driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File(basePath+"/FailedTCScreenshot/"+screenshotName+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			//byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//scenario.attach(sourcePath, "image/png", screenshotName);
 */
		}
	}
	

}
