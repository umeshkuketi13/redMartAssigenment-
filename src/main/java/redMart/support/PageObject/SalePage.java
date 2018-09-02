package redMart.support.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import redMart.stepdefinationloginpage.LoginPage;
import redMart.support.Loggerhelper.LoggerHelper;

public class SalePage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);		
		@FindBy(xpath="//*[@id='categoryNav']/section[1]/div[2]/a")
		public WebElement cliclOnSale;
		
		
		@FindBy(xpath="//*[@id='contentSection']/div/article/div[2]/div/div/ul/li[1]/div[3]/div/a/span")
		public  WebElement clickOnSaleaddtoCart;
		
		
		
		public SalePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		public SalePage salePage(){
			cliclOnSale.click();
			return  new SalePage(driver);
		}

		public  void clickonSaleaddtocart()
		
		{
		   clickOnSaleaddtoCart.click();	
			
		}
		
	}


