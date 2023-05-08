package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class NewWindowPages extends Utils {
	
	public WebDriver driver;
	
	public NewWindowPages(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[text()='New Window']")
	private WebElement NewWindowButtonEle;
	
	@FindBy (xpath="//h1[@id='sampleHeading']")
	private WebElement SecondWinHeadingEle;
	

	public WebElement getNewWindowButtonEle() {
		return NewWindowButtonEle;
	}

	public WebElement getSecondWinHeadingEle() {
		return SecondWinHeadingEle;
	}

}
