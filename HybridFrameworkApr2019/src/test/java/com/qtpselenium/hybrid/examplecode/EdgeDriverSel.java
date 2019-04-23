package com.qtpselenium.hybrid.examplecode;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriverSel {
	// pre requisites - careful with edge version
	// logs
	// page load strategy
	// binary - NO
	// PROXY-https://developer.microsoft.com/en-us/microsoft-edge/platform/issues/5468949/	
	// Profiling - NO
	// Notifications - NO
	// certificate
	 
	
	public static void main(String[] args) {
		// 
		//System.setProperty("webdriver.edge.driver", "D:\\Common\\drivers\\MicrosoftWebDriver.exe");
		System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"null");
		
		EdgeOptions options = new EdgeOptions();
		options.setPageLoadStrategy("eager");
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		
		// NOTIFICATIONS and PROFILE
		
		
		EdgeDriver driver = new EdgeDriver(options);// make sure previous session is closed
		//driver.manage().window().maximize();
			
			
		// cert
		driver.get("https://192.163.254.17:2083/");
		//2 line code
		driver.findElement(By.id("moreInformationDropdownSpan")).click();
		driver.findElement(By.id("invalidcert_continue")).click();
		
		/*
		driver.get("http://facebook.com");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Jungle@123");
		driver.findElement(By.name("pass")).sendKeys(Keys.ENTER);
		*/
	
	}

}
