package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class HomePage extends Utils {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[text()='Fashion']")
	private WebElement Fashion;
	
	@FindBy (xpath="//a[text()='Kids']")
	private WebElement KidsEle;
	
	@FindBy (xpath="//a[text()='Boys & Girls Jeans']")
	private WebElement BoysAndGirlsJeanEle;
		
	
	public  WebElement getFashionEle() {
		return Fashion;
	}

	public  WebElement getKidsEle() {
		return KidsEle;
	}

	public  WebElement getBoysAndGirlsJeanEle() {
		return BoysAndGirlsJeanEle;
	}
	
	public void goto2() {
		driver.get("https://www.flipkart.com/");
	}



}
