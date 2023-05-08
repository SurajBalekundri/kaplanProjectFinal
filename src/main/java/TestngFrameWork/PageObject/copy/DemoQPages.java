package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class DemoQPages extends Utils {
	
	WebDriver driver;
	
	public DemoQPages(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//iframe[@id='frame1']")
	private WebElement Frmae1Ele;
	
	@FindBy (xpath="//iframe[@srcdoc]")
	private WebElement Frame2Ele;
	
	@FindBy (xpath="//body/p")
	private WebElement childFrmaeContentEle;
	


	public WebElement getFrmae1Ele() {
		return Frmae1Ele;
	}

	public WebElement getFrame2Ele() {
		return Frame2Ele;
	}

	public WebElement getchildFrmaeContentEle() {
		return childFrmaeContentEle;
	}

}
