package Automation.SeleniumrepeatProject.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.SeleniumrepeatProject.PageObjects.CartPage;
import Automation.SeleniumrepeatProject.PageObjects.ProductCatalogue;
import Automation.SeleniumrepeatProjects.TestComponents.BaseTest;
import Automation.SeleniumrepeatProjects.TestComponents.Retry;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorValidations"} , retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("shreyasdosi48@gmail.com", "Mkyasv@1234");

		Assert.assertEquals("Incorrect email or password.", landingPage.errorMsg());

	}
	
	@Test(groups = {"ErrorValidations"})
	public void ProductValidation()
	{
		String ProductName = "ZARA COAT 3";
        
        ProductCatalogue productcatalogue = landingPage.loginApplication("shreyasdoshi48@gmail.com", "Mkyasv@1234");
		productcatalogue.addProductToCart(ProductName);
		
		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDispaly("ZARA CAOT 2");
		Assert.assertFalse(match);
	}

}
