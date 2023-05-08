package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class AddToCartPage extends Utils {
	
	public WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class='_3fSRat']//div[@class='_2-uG6-']")//div[@class='_2-uG6-']//a
	private WebElement ItemNameEle;
	
	@FindBy (xpath="//div[@class='_3fSRat']//span[contains(@class, '_1WpvJ7')]") //span[@class='_2-ut7f _1WpvJ7']
	private WebElement ItemPriceEle;
	
	
	public  WebElement getItemNameEle() {
		return ItemNameEle;
	}
	
	public  WebElement getItemPriceEle() {
		return ItemPriceEle;
	}


}
