package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class KidsJeansPage extends Utils {
	
	public WebDriver driver;
	
	public KidsJeansPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[text()='Price -- Low to High']")
	private WebElement LowToHighEle;
	
	@FindBy (xpath="//div[contains(@class, '_1YokD2')][2]//div[10]/div/div") // or //div[@class='_13oc-S']/div[2] or //div[@class='_13oc-S']//a  or //div[@class='_3ywSr_']//img
	private WebElement FirstItemEle;
	
	@FindBy (xpath ="//div[text()='Availability']")
	private WebElement availabilityEle;
	
	@FindBy (xpath ="//div[text()='Include Out of Stock']")
	private WebElement outOfStockEle;

	
	
	public  WebElement getLowToHighEle() {
		return LowToHighEle;
	}

	public  WebElement getFirstItemEle() {
		return FirstItemEle;
	}
	
	public  WebElement getAvailabilityEle() {
		return availabilityEle;
	}
	
	public  WebElement getoutOfStockEle() {
		return outOfStockEle;
	}

	

}
