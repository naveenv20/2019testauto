package com.qtpselenium.hybrid.examplecode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverSel {
//https://davidwalsh.name/demo/notifications-api.php
	public static void main(String[] args) {

		// zoom level
		// protected mode
		// Security - Allow contents
		// 32 bit or 64 bit IE
		
		
		// pre requisites - careful with IE version - 11
		// logs
		// page load strategy - NO
		// binary - NO
		// PROXY	
		// Profiling - NO
		// Notifications - NO
		// certificate
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY,"INFO");      
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY,"FATAL");      
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY,"ERROR");      
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
	   // System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
		InternetExplorerOptions options = new InternetExplorerOptions();
		//options.setPageLoadStrategy("");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setAcceptInsecureCerts(true);
		//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
/*
		String PROXY = "83.209.94.89:44557";
	      Proxy proxy = new Proxy();
	      proxy.setAutodetect(false);
	      proxy.setProxyType(Proxy.ProxyType.MANUAL);
	      proxy.setSocksProxy(PROXY);
	      cap.setCapability(CapabilityType.PROXY, proxy);
		  options.merge(cap);
*/		
		
		WebDriver driver = new InternetExplorerDriver(options);
    	driver.get("https://192.163.254.17/");
		//driver.get("javascript:document.getElementById('overridelink').click();");// standard code
		
		
		
		
	}

}
