package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class DragAndDropPage extends Utils {
	
	WebDriver driver;
	
	public DragAndDropPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[text()='Accept']")
	private WebElement AcceptEle;
	
	@FindBy (xpath="//div[text()='Not  Acceptable']")
	private WebElement NotAcceptableEle;
	
	@FindBy (xpath="(//div[@id='droppable'])[2]")
	private WebElement DropHereEle;
	

	public WebElement getAcceptEle() {
		return AcceptEle;
	}

	public WebElement getNotAcceptableEle() {
		return NotAcceptableEle;
	}

	public WebElement getDropHereEle() {
		return DropHereEle;
	}

}
