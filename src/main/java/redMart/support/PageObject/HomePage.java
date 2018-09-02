package redMart.support.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import redMart.stepdefinationloginpage.LoginPage;
import redMart.support.Loggerhelper.LoggerHelper;
import redMart.support.waithelper.WaitHelper;



public class HomePage {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//li[@data-id='128174']//div/a[@class='AtcButton__container___1RZ9c AtcButton__with_text___4C5OY AtcButton__small___1a1kH']")
	private  WebElement addToCartfromHome;
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void mouseOverOnProduct(int num){
		String fPart="//li[@data-id='";
		String sPart="']//div/a[@class='AtcButton__container___1RZ9c AtcButton__with_text___4C5OY AtcButton__small___1a1kH'//span[@class='AtcButton__button_text___VoXuy']";
		Actions action=new Actions(driver);
		log.info("doing mouse over on: "+num+"..product");
		action.moveToElement(driver.findElement(By.xpath(fPart+num+sPart))).build().perform();
	}

	public HomePage addtoCart()
	{
		addToCartfromHome.click();
		return new HomePage(driver);
	
				
	}
	
}
