package org.testfunction;

import org.common.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Procco_pages;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC002 extends BaseClass {

	public static WebDriverWait wait;
	@Test

	public void Loyalty_Content() throws InterruptedException {
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


	

		obj.loyalty_Hyperlink().click();

		String Loyalty_Title = obj.loyalty_Page_Title().getText();
		System.out.println("Loyalty page title is "+Loyalty_Title);
		if(Loyalty_Title.equals(prop.getProperty("loyalty_Page_Title"))) {
			
			System.out.println("Loyalty title is matching");
		}
		else{
			Assert.fail();	
		}

		
		
		if(obj.loyalty_Content().getText().equals(prop.getProperty("loyalty_Content"))) {
			System.out.println("Loyalty Content is matching");
		}

		else {
			
			System.out.println("Loyalty content is not matching");
			
			String url = driver.getCurrentUrl();
            System.out.println("Current URL is"+url);
            
            Assert.fail("URL is "+url+" "+'\n'+'\n'
                        +"Expected result :" +obj.loyalty_Content().getText()+
                        '\n'+ '\n'+"Actual Result :" + prop.getProperty("loyalty_Content") ); 
                     
		}

	}
	

}






