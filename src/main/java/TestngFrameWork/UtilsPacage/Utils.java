package TestngFrameWork.UtilsPacage;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public WebDriver driver;
	
	public Utils(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void perfromEscButton() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public  void hoverAnElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public  void clickOnEle(WebElement ele) {
		waitForElement(ele);
		ele.click();
	}

	public String getEleText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public void switchToSecondWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (!next.equals(parentWindow)) {
				driver.switchTo().window(next);
			}
		}
	}

	public void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForEle() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void waitForAlertToBePresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void sendKeysInAlert() {
		driver.switchTo().alert().sendKeys("Suraj");
		driver.switchTo().alert().accept();
	}

	public void dragAndDrop(WebElement eleSource, WebElement eleDest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(eleSource, eleDest).build().perform();
	}

	
}
