package Automation.SeleniumrepeatProject.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.SeleniumrepeatProject.PageObjects.CartPage;
import Automation.SeleniumrepeatProject.PageObjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By byelement)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(byelement));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementToDisAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	
	public void scrolltoEle()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(1440,900)"); 
	}
}
