package Automation.SeleniumrepeatProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.SeleniumrepeatProject.Utilities.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	@FindBy(css=".ng-animating")
	WebElement animating;
	
	By poductby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	
	public List<WebElement> ProductList()
	{
		waitForElementToAppear(poductby);
		return Products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod = ProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName)
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDisAppear(animating);
	}
}
