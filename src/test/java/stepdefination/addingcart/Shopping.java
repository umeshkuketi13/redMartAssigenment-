package stepdefination.addingcart;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import redMart.stepdefinationloginpage.LoginPage;
import redMart.support.Loggerhelper.LoggerHelper;
import redMart.support.PageObject.AddressPage;
import redMart.support.PageObject.CartPage;
import redMart.support.PageObject.HomePage;
import redMart.support.PageObject.RedMartLoginPage;
import redMart.support.PageObject.SalePage;
import redMart.support.base.TestBase;
import redMart.support.config.ObjectRepo;
import redMart.support.javascripthelper.JavaScriptHelper;
import redMart.support.waithelper.WaitHelper;

public class Shopping {

	private final Logger log = LoggerHelper.getLogger(Shopping.class);
	RedMartLoginPage redMartLoginPage;
	HomePage homePage;
	SalePage salePage;
	CartPage cartPage;
	AddressPage addressPage;
		
	WaitHelper wait = new WaitHelper(TestBase.driver);
	JavaScriptHelper js=new JavaScriptHelper(TestBase.driver);

	@Given("^Lunch the brower$")
	public void lunch_the_brower() throws Throwable {

		TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@When("^user click on sign in link$")
	public void user_click_on_sign_in_link() throws Throwable {
		redMartLoginPage = new RedMartLoginPage(TestBase.driver);
		redMartLoginPage.loginIn();

	}

	@When("^enter email address as \"(.*?)\"$")
	public void enter_email_address_as(String arg1) throws Throwable {
		redMartLoginPage.enterEmailAddress(arg1);

	}

	@When("^enter password as \"(.*?)\"$")
	public void enter_password_as(String arg1) throws Throwable {

		redMartLoginPage.enterLoginPassword(arg1);
	}

	@When("^click on sign in button$")
	public void click_on_sign_in_button() throws Throwable {
		redMartLoginPage.clickOnLoginButton();
		
		
	}
		

	@When("^search the iteam MarketPlace and add to cart$")
	public void search_the_iteam_MarketPlace_and_add_to_cart() throws Throwable {
		homePage=new HomePage(TestBase.driver);
		js.scrollDownByPixel();
		homePage.mouseOverOnProduct(128174);
		//TestBase.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("marketplace");
	//	TestBase.driver.findElement(By.xpath("//button[@class='SearchInputBox__button___1sNM_']")).click();
		log.info("Adding one item");
		wait.setImplicitWait(10,TimeUnit.SECONDS);
		//TestBase.driver.findElement(By.xpath("//li[@data-id='188831']//div/a[@class='AtcButton__container___1RZ9c AtcButton__with_text___4C5OY AtcButton__small___1a1kH']//span[@class='AtcButton__button_text___VoXuy']")).click();
		
		
		
	}

	@When("^search the iteam On sale and add to cart$")
	public void search_the_iteam_On_sale_and_add_to_cart() throws Throwable {

		salePage=new SalePage(TestBase.driver);
		salePage.salePage();
		log.info("Adding one item from sale page...");
		js.scrollDownByPixel();
		salePage.clickonSaleaddtocart();
		
	}

	@When("^go to the cart and remove second iteam from cart$")
	public void go_to_the_cart_and_remove_second_iteam_from_cart() throws Throwable {

		cartPage=new CartPage(TestBase.driver);
		cartPage.myCartPage();
		log.info("Redirecting to cart page...");
		js.scrollDownByPixel();
		log.info("Removing the second item from the cart...");
		cartPage.removeSeconditeam();
		wait.setImplicitWait(10,TimeUnit.SECONDS);
			
			
		
	}

	@When("^click on checkout$")
	public void click_on_checkout() throws Throwable {
		log.info("Proceed to checkout...");
		cartPage.checkOutPage();	

	}

	@When("^edit the address$")
	public void edit_the_address() throws Throwable {
		addressPage=new AddressPage(TestBase.driver);
		addressPage.clickonAddress();
		log.info("Redirecting to address page...");
		addressPage.enterPinCode();
		wait.setImplicitWait(10, TimeUnit.SECONDS);
		addressPage.selectAddress();
	}

	@Then("^log out from browser$")
	public void log_out_from_browser() throws Throwable {

	}

}
