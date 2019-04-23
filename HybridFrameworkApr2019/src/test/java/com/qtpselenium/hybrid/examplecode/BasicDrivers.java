package com.qtpselenium.hybrid.examplecode;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;
// automation -  stable projects - functional phase

public class BasicDrivers {
	
	@Test
	public void launchSite(){
	//https://ftp.mozilla.org/pub/firefox/releases/
		// timeout 45000 -  binary of firefox not found
		System.setProperty("webdriver.gecko.driver", "D:\\Common\\drivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		//driver.get("http://yahoo.com");
		// 3.8.1 - 55
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Common\\drivers\\chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "D:\\Common\\drivers\\chromedriver.exe");
		ChromeDriver cd = new ChromeDriver();
		cd.get("http://yahoo.com");
		cd.quit();
		
		// IE
		// zoom level 100%
		// protected mode turned off and level to least positions
		// security setting - allow active content
		// 32 or 64
		//System.setProperty("webdriver.ie.driver", "D:\\Common\\drivers\\IEDriverServer.exe");
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "D:\\Common\\drivers\\IEDriverServer.exe");
		InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.get("http://yahoo.com");
		driver.quit();// closes exe.. browser.. selenium session
		//driver.close();
		
		// Edge
		// careful about version of exe
		//System.setProperty("webdriver.edge.driver", "D:\\Common\\drivers\\MicrosoftWebDriver.exe");
		EdgeDriver ed = new EdgeDriver();
		ed.get("http://yahoo.com");
		driver.quit();
		
		
		
		
	}

}
