package TestngFrameWork.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import TestngFrameWork.PageObject.copy.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	ReadConfig readConfig = new ReadConfig();
	
	public WebDriver driver;
	public HomePage HomePage;
	public String browserName = readConfig.getBrowser();
	public String flipkartURL = readConfig.getFlipkartURL();
	public String DemoframeURL = readConfig.getframeURL();
	public String DemoalertURL = readConfig.getalertURL();
	public String DemoDragdropURL = readConfig.getDragdropURLL();
	public String DemonewWindow = readConfig.getnewWindow();
	
	public WebDriver initializeDriver() throws IOException {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./setup/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "./setup/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException {
		//BaseTest BaseTest = new BaseTest();
		//driver = BaseTest.initializeDriver();
		driver = initializeDriver();
		HomePage = new HomePage(driver);
		return HomePage;
	}


	public String getScreenshot(String tescaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + tescaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + tescaseName + ".png";
		
	}
	
	

}


