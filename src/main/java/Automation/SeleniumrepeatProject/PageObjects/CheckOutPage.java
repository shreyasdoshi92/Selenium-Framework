package Automation.SeleniumrepeatProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Automation.SeleniumrepeatProject.Utilities.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-results")
	WebElement submit;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement SelectdropdownValue;	
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;	
	
	By submitby = By.cssSelector(".ta-results");
	
	public void selectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, CountryName).build().perform();
		waitForElementToAppear(submitby);
		SelectdropdownValue.click();
		
	}
	
	public ConfrmationPage submitOrder() throws InterruptedException
	{
		scrolltoEle();
		waitForWebElementToAppear(placeOrder);
		placeOrder.click();
		ConfrmationPage confirmationPage = new ConfrmationPage(driver);
		return confirmationPage;
	}
}
