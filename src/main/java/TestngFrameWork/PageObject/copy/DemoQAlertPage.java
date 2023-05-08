package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class DemoQAlertPage extends Utils {
	
	public WebDriver driver;
	
	public DemoQAlertPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[@id='alertButton']")
	private WebElement FirstClickMeButton;
	
	@FindBy (xpath="//button[@id='timerAlertButton']")
	private WebElement SecondClickMeButton;
	
	@FindBy (xpath="//button[@id='confirmButton']")
	private WebElement ThirdClickMeButton;
	
	@FindBy (xpath="//button[@id='promtButton']")
	private WebElement FourthClickMeButton;
	
	public WebElement getFirstClickMeButton() {
		return FirstClickMeButton;
	}
	
	public WebElement getSecondClickMeButton() {
		return SecondClickMeButton;
	}
	
	public WebElement getThirdClickMeButton() {
		return ThirdClickMeButton;
	}
	
	public WebElement getFourthClickMeButton() {
		return FourthClickMeButton;
	}

}
