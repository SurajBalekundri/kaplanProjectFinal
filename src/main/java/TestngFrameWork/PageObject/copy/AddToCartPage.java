package TestngFrameWork.PageObject.copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestngFrameWork.UtilsPacage.Utils;

public class AddToCartPage extends Utils {
	
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class='_2-uG6-']//a")
	private WebElement ItemNameEle;
	
	@FindBy (xpath="//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement ItemPriceEle;
	
	
	public  WebElement getItemNameEle() {
		return ItemNameEle;
	}
	
	public  WebElement getItemPriceEle() {
		return ItemPriceEle;
	}


}
