package TestngFrameWork.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestngFrameWork.PageObject.copy.AddToCartPage;
import TestngFrameWork.PageObject.copy.DemoQAlertPage;
import TestngFrameWork.PageObject.copy.DemoQPages;
import TestngFrameWork.PageObject.copy.DragAndDropPage;
import TestngFrameWork.PageObject.copy.ItemPage;
import TestngFrameWork.PageObject.copy.KidsJeansPage;
import TestngFrameWork.PageObject.copy.NewWindowPages;
import TestngFrameWork.TestComponents.BaseTest;
import TestngFrameWork.UtilsPacage.Utils;

public class TestCase extends BaseTest{
	
	@Test
	
	public void Flipkart() throws IOException {
		//BaseTest baseTest = new BaseTest();
		
		//driver.get("https://www.flipkart.com/");
		driver.get(flipkartURL);
		Utils utils = new Utils(driver);

		utils.perfromEscButton();
		utils.hoverAnElement(HomePage.getFashionEle());
		utils.hoverAnElement(HomePage.getKidsEle());
		utils.hoverAnElement(HomePage.getBoysAndGirlsJeanEle());
		utils.clickOnEle(HomePage.getBoysAndGirlsJeanEle());
		utils.waitForEle();

		KidsJeansPage KidsJeansPage = new KidsJeansPage(driver);
		utils.clickOnEle(KidsJeansPage.getLowToHighEle());
		utils.waitForEle();
		utils.hoverAnElement(KidsJeansPage.getAvailabilityEle());
		utils.clickOnEle(KidsJeansPage.getAvailabilityEle());

		utils.clickOnEle(KidsJeansPage.getoutOfStockEle());
		utils.waitForEle();

		utils.hoverAnElement(KidsJeansPage.getFirstItemEle());//change ele to get 1st item even after applying any filter
		utils.clickOnEle(KidsJeansPage.getFirstItemEle());
		utils.switchToSecondWindow();
		
		ItemPage ItemPage = new ItemPage(driver);
		utils.clickOnEle(ItemPage.getItemSizeEle());
		String expectedItemName = utils.getEleText(ItemPage.getItemNameEle());
		String expectedItemPrice = utils.getEleText(ItemPage.getItemPriceEle());
		System.out.println(expectedItemName);
		System.out.println(expectedItemPrice);

		utils.clickOnEle(ItemPage.getAddToCartButtonEle());
		utils.clickOnEle(ItemPage.getcartButtonEle());
		
		AddToCartPage AddToCartPage = new AddToCartPage(driver);
		String actualItemNameOnCartPage = utils.getEleText(AddToCartPage.getItemNameEle());
		String actualItemPriceOnCartPage = utils.getEleText(AddToCartPage.getItemPriceEle());
		System.out.println(actualItemNameOnCartPage);
		System.out.println(actualItemPriceOnCartPage);
		Assert.assertEquals(actualItemNameOnCartPage.contains(expectedItemName), true, "Does not match wiht the name");
		Assert.assertEquals(actualItemPriceOnCartPage.contains(expectedItemPrice), true,
				"Does not match with the price");
		
		
	}
	
	@Test (groups = {"Regression"})
	public void test2() {
		
		driver.get(DemoframeURL);
		Utils utils = new Utils(driver);
		DemoQPages DemoQPages = new DemoQPages(driver);

		utils.switchFrame(DemoQPages.getFrmae1Ele());
		utils.switchFrame(DemoQPages.getFrame2Ele());
		String childFrmaeContent = utils.getEleText(DemoQPages.getchildFrmaeContentEle());
		System.out.println("content of child iframe is:- " + childFrmaeContent);
	}
	
	@Test
	public void test3() {
		driver.get(DemoalertURL);
		Utils utils = new Utils(driver);
		DemoQAlertPage DemoQAlertPage= new DemoQAlertPage(driver);		

		utils.clickOnEle(DemoQAlertPage.getFirstClickMeButton());
		utils.acceptAlert();
		utils.clickOnEle(DemoQAlertPage.getSecondClickMeButton());
		utils.waitForAlertToBePresent();
		utils.acceptAlert();
		utils.clickOnEle(DemoQAlertPage.getThirdClickMeButton());
		utils.acceptAlert();
		utils.clickOnEle(DemoQAlertPage.getFourthClickMeButton());
		utils.waitForEle();
		utils.sendKeysInAlert();
	}

	@Test
	public void test4() {
		driver.get(DemoDragdropURL);
		Utils utils = new Utils(driver);
		DragAndDropPage DragAndDropPage = new DragAndDropPage(driver);

		
		utils.clickOnEle(DragAndDropPage.getAcceptEle());
		utils.dragAndDrop(DragAndDropPage.getNotAcceptableEle(), DragAndDropPage.getDropHereEle());
	}

	@Test (groups = {"Regression"})
	public void test5() {
		
		driver.get(DemonewWindow);
		Utils utils = new Utils(driver);
		NewWindowPages NewWindowPages = new NewWindowPages(driver);

		utils.clickOnEle(NewWindowPages.getNewWindowButtonEle());
		utils.switchToSecondWindow();
		String actualText = utils.getEleText(NewWindowPages.getSecondWinHeadingEle());
		Assert.assertEquals(actualText.equals("This is a sample page"), true, "expected text is present");
	}
	
}