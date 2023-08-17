package Automation.SeleniumrepeatProjects.StepDefinations;

import java.io.IOException;

import org.testng.Assert;

import Automation.SeleniumrepeatProject.PageObjects.CartPage;
import Automation.SeleniumrepeatProject.PageObjects.CheckOutPage;
import Automation.SeleniumrepeatProject.PageObjects.ConfrmationPage;
import Automation.SeleniumrepeatProject.PageObjects.LandingPage;
import Automation.SeleniumrepeatProject.PageObjects.OrderPage;
import Automation.SeleniumrepeatProject.PageObjects.ProductCatalogue;
import Automation.SeleniumrepeatProjects.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderStepDefination extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public CheckOutPage checkOutPage;
	public ConfrmationPage confirmationPage;
	public OrderPage orderpage;
	
	@Given("I landed on the ecommerce page")
	public void i_landed_on_the_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productcatalogue = landingPage.loginApplication(username, password);
	   
	}

	@When("^I add the product (.+) to the cart$")
	public void i_add_the_product_to_the_cart(String Product) {
		productcatalogue.addProductToCart(Product);
	   
	}

	@When("^checkout (.+) and select the country (.+) and submit the order$")
	public void checkout_productname_and_select_the_country_and_submit_the_order(String Product, String country) throws InterruptedException {
		cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDispaly(Product);
		Assert.assertTrue(match);

		checkOutPage = cartpage.goToCheckout();
		checkOutPage.selectCountry(country);

		confirmationPage = checkOutPage.submitOrder();
	}

	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String msg) {
		String FinalSuccessMsg = confirmationPage.confirmationMsg();
		Assert.assertTrue(FinalSuccessMsg.equalsIgnoreCase(msg));
		driver.close();
	
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed_login_page(String msg) {
		Assert.assertEquals(msg, landingPage.errorMsg());
		driver.close();
	
	}
	
	@When("Go to orders page clicking on Orders")
	public void Go_to_orders_page_clicking_on_Orders() {
		orderpage =productcatalogue.goToOrderPage();
	   
	}
	
	@Then("^(.+) is displayed on order page$")
	public void Product_is_displayed_on_order_page(String ProductName)
	{
		Assert.assertTrue(orderpage.verifyProductDispaly(ProductName));
		driver.close();
	}
	
	@Then("^(.+) is displayed on cart page$")
	public void Product_is_displayed_on_cart_page(String ProductName)
	{
		cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDispaly(ProductName);
		Assert.assertTrue(match);
		driver.close();
	}

}
