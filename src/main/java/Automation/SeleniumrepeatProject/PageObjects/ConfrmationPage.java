package Automation.SeleniumrepeatProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Automation.SeleniumrepeatProject.Utilities.AbstractComponent;

public class ConfrmationPage extends AbstractComponent {
	WebDriver driver;
	
	public ConfrmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".hero-primary")
	WebElement confirmText;
	
	public String confirmationMsg()
	{
		String FinalSuccessMsg = confirmText.getText();
		return FinalSuccessMsg;
	}
	

}
