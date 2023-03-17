package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Procco_pages {
	
WebDriver driver;
	
	public Procco_pages (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//li[@class='page-collection active-link']//a)[2]")
	WebElement Home_Hyperlink;	
	public WebElement Home_Hyperlink() {
		return Home_Hyperlink;	
	}
	
	
	@FindBy(xpath ="(//div[@class='sqs-block-content']//h1)[1]")
	WebElement Home_Title;
	public WebElement Home_Title() {
		return Home_Title;
		
	}
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//h3//a)[1]")
	WebElement Instalment_Title;	
	public WebElement Instalment_Hyperlink() {
		return Instalment_Title;
	}
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//h3//a)[2]")
	WebElement loyalty_Hyperlink;	
	public WebElement loyalty_Hyperlink() {
		return loyalty_Hyperlink;
	}

	
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//h1)[1]")
	WebElement Instalment_Page_Title;	
	public WebElement Instalment_Page_Title() {
		return Instalment_Page_Title;	
	}
	
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//p)[1]")
	WebElement Instalment_Content;	
	public WebElement Instalment_Content() {
		return Instalment_Content;	
	}
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//h1)[1]")
	WebElement loyalty_Page_Title;	
	public WebElement loyalty_Page_Title() {
		return loyalty_Page_Title;	
	}
	
	@FindBy(xpath="(//div[@class='sqs-block-content']//p)[1]")
	WebElement loyalty_Content;	
	public WebElement loyalty_Content() {
		return loyalty_Content;	
	}
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement Cookies_OK;	
	public WebElement Cookies_OK() {
		return Cookies_OK;	
	}
	
	
	
	
	


}
