package Automation.SeleniumrepeatProject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	
	
	@Test(dataProvider = "getData1",groups = {"ErrorValidations"})
	public void ProductValidation(HashMap<String,String> input1)
	{
		String ProductName = input1.get("ProductName");
        
        ProductCatalogue productcatalogue = landingPage.loginApplication(input1.get("username"), input1.get("password"));
		productcatalogue.addProductToCart(ProductName);
		
		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDispaly(input1.get("ProductName"));
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData1() throws IOException {
		//json file to hapshmap
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\SeleniumrepeatProjects\\Data\\VerifyProducts.json");
		
		return new Object[][] { {data.get(0)}, 
								{data.get(1)} };
	}
	

}
