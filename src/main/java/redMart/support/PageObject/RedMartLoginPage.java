package redMart.support.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import redMart.support.Loggerhelper.LoggerHelper;
import redMart.support.base.TestBase;
import redMart.support.config.ObjectRepo;
import redMart.support.waithelper.WaitHelper;

public class RedMartLoginPage  {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RedMartLoginPage.class);
	WaitHelper waitHelper;
		
	//PageFactory
	@FindBy(xpath="//*[@id='NAVBAR_SIGNUP_BTN']/span")
	public  WebElement signUp;

	@FindBy(xpath="//input[@type='email']")
	public WebElement  emaiiAddress;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//*[@id='modal']/div/span/div/div/div/div/div[4]/div")
	public WebElement signUpButton;
	
	
	// existing user
	
	@FindBy(xpath="//*[@id='NAVBAR_SIGNIN_BTN']/span")
	public WebElement clickOnLoginButton;
	
	@FindBy(xpath="//*[@id='modal']/div/span/div/div/div/div/div[1]/div/input")
	public WebElement loginEmail;
	
	@FindBy(xpath="//*[@id='modal']/div/span/div/div/div/div/div[2]/div/input")
	public WebElement loginpassword;
	
	@FindBy(xpath="//*[@id='modal']/div/span/div/div/div/div/div[3]/div")
	public WebElement clickOnSignInButton;
	
	//Initializing the Page Object
		public RedMartLoginPage(WebDriver driver)
		{	this.driver = driver;
			PageFactory.initElements(driver, this);
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(driver, clickOnLoginButton,ObjectRepo.reader.getExplicitWait());
		}
	
		
		public void loginIn()
		{
			log.info("clicked on sign in link...");
			clickOnLoginButton.click();
		}
		public void enterEmailAddress(String loginEmail)
		{
			log.info("Entering the email address"+loginEmail);
			this.loginEmail.sendKeys(loginEmail);
		}
		public void enterLoginPassword(String loginpassword)
		{
			log.info("Entering the password"+loginpassword);
			this.loginpassword.sendKeys(loginpassword);
		}

	
		
		public  HomePage clickOnLoginButton(){
			
			log.info("clicking on loging button");
			clickOnSignInButton.click();
			return new HomePage(driver);
			
			
		}
		
}
