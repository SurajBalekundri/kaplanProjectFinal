package TestngFrameWork.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig()  {
		File src = new File(System.getProperty("user.dir") +
				"//src//main//java//TestngFrameWork//Resource//GlobalData.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e){
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getFlipkartURL() {
		String flipkartURL = prop.getProperty("flipkartURL");
		return flipkartURL;
	}
	
	public String getBrowser() {
		String browserName= prop.getProperty("browser");
		return browserName;
	}
	
	public String getframeURL() {
		String DemoframeURL= prop.getProperty("frameURL");
		return DemoframeURL;
	}
	
	public String getalertURL() {
		String DemoalertURL= prop.getProperty("alertURL");
		return DemoalertURL;
	}
	
	public String getDragdropURLL() {
		String DemoDragdropURL= prop.getProperty("DragdropURL");
		return DemoDragdropURL;
	}
	
	public String getnewWindow() {
		String DemonewWindow= prop.getProperty("newWindow");
		return DemonewWindow;
	}

}