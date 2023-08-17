package Automation.SeleniumrepeatProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.SeleniumrepeatProject.Utilities.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProducts; 
	

	
	public Boolean verifyProductDispaly(String ProductName)
	{
		Boolean match = orderProducts.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(ProductName));
		return match;
	}


}
