package org.testfunction;

import org.common.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Procco_pages;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC001 extends BaseClass {

	public static WebDriverWait wait;
	
	@Test(priority = 1)

	public void tc_001_Instalment_Content() throws InterruptedException {

		Procco_pages obj=new Procco_pages(driver);

		if(obj.Cookies_OK().isDisplayed()) {
			obj.Cookies_OK().click();
		}

		
		Thread.sleep(2000);	

		String Home_title = obj.Home_Title().getText();
		System.out.println("Home page title is "+Home_title);

		if(Home_title.contains(prop.getProperty("Home_Title"))) {

			System.out.println("Home title is matching");
		}
		else {
			Assert.fail();
			System.out.println("Home page title is not matching");
		}
		
		obj.Instalment_Hyperlink().click();

		String Instalment_Title = obj.Instalment_Page_Title().getText();
		System.out.println("Instalment page title is "+Instalment_Title);
		
		
	
		if(Instalment_Title.equals(prop.getProperty("Instalment_Title"))) {
			
			if(obj.Instalment_Content().getText().equals(prop.getProperty("Instalment_Content"))) {
				System.out.println("Instalment_Content is matching");

			}

			else {
				
				 
				Assert.fail();
			}
		}
		else{
			Assert.fail();	
		}
		
		
		
	
	}
}






