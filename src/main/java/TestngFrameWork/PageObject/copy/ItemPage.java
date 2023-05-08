package TestngFrameWork.PageObject.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngFrameWork.UtilsPacage.Utils;

public class ItemPage extends Utils {
	
	public WebDriver driver;
	
	public ItemPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[contains(@class, 'ffYZ17')][2]//li") //a[text()='5 - 8 Years']
	private WebElement ItemSizeEle;
	
	@FindBy (xpath="//span[@class='G6XhRU']/following-sibling::span")
	private WebElement ItemNameEle;
	
	@FindBy (xpath="//div[@class='_25b18c']/div[1]")
	private WebElement ItemPriceEle;
	
	@FindBy (xpath="//li[@class='col col-6-12'][1]") //button[text()='Add to cart'] or //div[@class='_1AtVbE col-12-12']//button
	private WebElement AddToCartButtonEle;
	
	@FindBy (xpath="//div[@class='YUhWwv']")
	private WebElement cartButtonEle;

		
	public WebElement getItemSizeEle() {
		return ItemSizeEle;
	}

	public WebElement getItemNameEle() {
		return ItemNameEle;
	}

	public WebElement getItemPriceEle() {
		return ItemPriceEle;
	}
	
	public WebElement getAddToCartButtonEle() {
			
		return AddToCartButtonEle;
	}
	
	public WebElement getcartButtonEle() {
		return cartButtonEle;
	}


}
