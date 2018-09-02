package redMart.support.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import redMart.support.Loggerhelper.LoggerHelper;
import redMart.support.config.ObjectRepo;
import redMart.support.waithelper.WaitHelper;

public class CartPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RedMartLoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//div[@class='NavbarCartTotal__container___15sws']")
	public WebElement clickonCartPage;
	
	@FindBy(xpath="//*[@id='cartPreviewProductList']/div/div[1]/div[2]/li/div[2]/div/div/button")
	public WebElement removeScondItemfromCart;
	
	
	@FindBy(xpath="//*[@id='ordersummary']/div[1]/div/div")
	public WebElement clickOnCheckOut;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, clickonCartPage,ObjectRepo.reader.getExplicitWait());
	}

	
	public CartPage  myCartPage()
	{
		clickonCartPage.click();
		return new CartPage(driver);
	}

	public void  removeSeconditeam(){
		removeScondItemfromCart.click();
		
	}
	
	public void checkOutPage()
	{
		clickOnCheckOut.click();
		
	}

}
