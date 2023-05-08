package TestngFrameWork.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestngFrameWork.PageObject.copy.AddToCartPage;
import TestngFrameWork.PageObject.copy.DemoQAlertPage;
import TestngFrameWork.PageObject.copy.DemoQPages;
import TestngFrameWork.PageObject.copy.DragAndDropPage;
import TestngFrameWork.PageObject.copy.HomePage;
import TestngFrameWork.PageObject.copy.ItemPage;
import TestngFrameWork.PageObject.copy.KidsJeansPage;
import TestngFrameWork.PageObject.copy.NewWindowPages;
import TestngFrameWork.TestComponents.BaseTest;
import TestngFrameWork.UtilsPacage.Utils;

public class TestCaseNew extends BaseTest{
	
	@Test
	
	public void Flipkart() throws IOException {
		
		driver.get(flipkartURL);
		
		Utils utils = new Utils(driver);

		utils.perfromEscButton();
		utils.hoverAnElement(HomePage.getFashionEle());
		utils.clickOnEle(HomePage.getFashionEle());
		utils.hoverAnElement(HomePage.getKidsEle());
		utils.hoverAnElement(HomePage.getBoysAndGirlsJeanEle());
		utils.clickOnEle(HomePage.getBoysAndGirlsJeanEle());

		KidsJeansPage KidsJeansPage = new KidsJeansPage(driver);
		//utils.waitForElement(KidsJeansPage.getLowToHighEle());
		//utils.waitForEle();
		utils.clickOnEle(KidsJeansPage.getLowToHighEle());
		utils.waitForElement(KidsJeansPage.getFirstItemEle());
		utils.hoverAnElement(KidsJeansPage.getFirstItemEle());
		utils.waitForEle();
		utils.clickOnEle(KidsJeansPage.getFirstItemEle());
		utils.switchToSecondWindow();
		
		ItemPage ItemPage = new ItemPage(driver);
		utils.clickOnEle(ItemPage.getItemSizeEle());
		String expectedItemName = utils.getEleText(ItemPage.getItemNameEle());
		String expectedItemPrice = utils.getEleText(ItemPage.getItemPriceEle());
		utils.waitForEle();
		utils.waitForElement(ItemPage.getAddToCartButtonEle());
		utils.hoverAnElement(ItemPage.getAddToCartButtonEle());
		utils.clickOnEle(ItemPage.getAddToCartButtonEle());
		
		
		AddToCartPage AddToCartPage = new AddToCartPage(driver);
		utils.clickOnEle(ItemPage.getAddToCartButtonEle());
		
		String actualItemNameOnCartPage = utils.getEleText(AddToCartPage.getItemNameEle());
		String actualItemPriceOnCartPage = utils.getEleText(AddToCartPage.getItemPriceEle());
		Assert.assertEquals(actualItemNameOnCartPage.contains(expectedItemName), true, "Does not match with the name");
		Assert.assertEquals(actualItemPriceOnCartPage.contains(expectedItemPrice), true,
				"Does not match with the price");
		
		
	}
	
	@Test (groups = {"RegressionTest"})
	public void test2() {
		driver.get(DemoframeURL);
		Utils utils = new Utils(driver);
		DemoQPages DemoQPages = new DemoQPages(driver);
		utils.switchFrame(DemoQPages.getFrmae1Ele());
		utils.switchFrame(DemoQPages.getFrame2Ele());
		String childFrmaeContent = utils.getEleText(DemoQPages.getchildFrmaeContentEle());
		System.out.println("Content of child iframe is:- " + childFrmaeContent);
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

	@Test (groups = {"RegressionTest"})
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