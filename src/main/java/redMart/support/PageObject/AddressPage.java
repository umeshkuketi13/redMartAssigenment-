package redMart.support.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import redMart.support.Loggerhelper.LoggerHelper;
import redMart.support.config.ObjectRepo;
import redMart.support.waithelper.WaitHelper;

public class AddressPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RedMartLoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='addresses']/div/section[1]/ul/li/div[1]/a")
	public WebElement editAddress;
	
	@FindBy(xpath="//*[@id='ADDRESS_WIZARD_SUGGESTIONS_INPUT']")
	public WebElement enterPinCode;
	
	@FindBy(xpath="//*[@id='addNewAddress']/a")
	public WebElement selectAddress;
	
	
	
	public  AddressPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, editAddress,ObjectRepo.reader.getExplicitWait());
		
	}
	
	public AddressPage clickonAddress(){
		editAddress.click();
		return new AddressPage(driver);
	}
	
	public void enterPinCode(){
		
		enterPinCode.sendKeys("619747");
	}
	public void selectAddress(){
		
		selectAddress.click();
	}
}
