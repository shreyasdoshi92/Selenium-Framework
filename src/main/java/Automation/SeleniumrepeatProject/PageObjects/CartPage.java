package Automation.SeleniumrepeatProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.SeleniumrepeatProject.Utilities.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts; 
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public Boolean verifyProductDispaly(String ProductName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public CheckOutPage goToCheckout()
	{
		checkoutEle.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

}
