package org.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath = System.getProperty("user.dir");
	
		@BeforeMethod

		public void initDriver() throws IOException {

			String projectPath = System.getProperty("user.dir");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			prop = new Properties();
			FileInputStream fis= new FileInputStream(projectPath + "/configuration/confiq.properties1");
			prop.load(fis);

			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		
		@AfterMethod
		public void clsDriver() {
			
			driver.close();
			driver.quit();
			
				
			}

		}
	
		

	
		
	
	
	


