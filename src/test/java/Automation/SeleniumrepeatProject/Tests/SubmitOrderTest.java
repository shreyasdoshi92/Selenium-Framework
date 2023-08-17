package Automation.SeleniumrepeatProject.Tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.SeleniumrepeatProject.PageObjects.CartPage;
import Automation.SeleniumrepeatProject.PageObjects.CheckOutPage;
import Automation.SeleniumrepeatProject.PageObjects.ConfrmationPage;
import Automation.SeleniumrepeatProject.PageObjects.OrderPage;
import Automation.SeleniumrepeatProject.PageObjects.ProductCatalogue;
import Automation.SeleniumrepeatProjects.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String ProductName = "ZARA COAT 3";
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		

		ProductCatalogue productcatalogue = landingPage.loginApplication(input.get("username"), input.get("password"));
		productcatalogue.addProductToCart(input.get("ProductName"));

		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDispaly(input.get("ProductName"));
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartpage.goToCheckout();
		checkOutPage.selectCountry(input.get("CountryName"));

		ConfrmationPage confirmationPage = checkOutPage.submitOrder();
		String FinalSuccessMsg = confirmationPage.confirmationMsg();
		Assert.assertTrue(FinalSuccessMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OderDisplay()
	{
		ProductCatalogue productcatalogue = landingPage.loginApplication("shreyasdoshi48@gmail.com", "Mkyasv@1234");
		OrderPage orderpage =productcatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.verifyProductDispaly(ProductName));
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//json file to hapshmap
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\SeleniumrepeatProjects\\Data\\PurchaseOrder.json");
		
		return new Object[][] { {data.get(0)}, 
								{data.get(1)} };
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("username", "shreyasdoshi48@gmail.com");
//		map.put("password", "Mkyasv@1234");
//		map.put("ProductName", "ZARA COAT 3");
//		map.put("CountryName", "india");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("username", "sswarali05@gmail.com");
//		map1.put("password", "Ssd@12345");
//		map1.put("ProductName", "ADIDAS ORIGINAL");
//		map1.put("CountryName", "aus");
//		
//		return new Object[][] { {map}, 
//								{map1} };
//	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { {"shreyasdoshi48@gmail.com","Mkyasv@1234","ZARA COAT 3"}, 
//								{"sswarali05@gmail.com","Ssd@12345","ADIDAS ORIGINAL"} };
//	}

}
