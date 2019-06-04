package com.qtpselenium.hybrid.examplecode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Dice_pagination {
	WebDriver driver;
	
	@Test
	public void searchJobs() throws InterruptedException{
		String tool="Selenium WebDriver";// watch module 7 and pass tool and location from xls+ testng dataprovider
		String location="New York, NY";
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
		
	    driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.dice.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		selectValue(tool);
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("New York");
		Thread.sleep(3000);
		selectValue(location);
		driver.findElement(By.xpath("//button[@id='findTechJobs']")).click();
		waitForPageToLoad();
		int i=1;
		while(i<=5){
		System.out.println("*************Page Number "+ i);	
		
			List<WebElement> jobLinks = driver.findElements(By.xpath("//a[contains(@id,'position')]"));
			for(WebElement e:jobLinks){
				if(!e.getText().trim().equals(""))
					System.out.println(e.getText());
			}
			i++;
			if(i==6)
				break;
			
			driver.findElement(By.xpath("//a[text()='"+i+"']")).click();
		}
	}
	
	public void selectValue(String selection){
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']/li"));
		System.out.println("Total options - "+options.size());
		for(WebElement e:options){
			System.out.println(e.getText());
			if(e.getText().equals(selection)){
				Actions act = new Actions(driver);
				act.click(e).build().perform();
				break;
			}
		}
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		wait(2);// wait of 2 sec between page status and jquery
		// check for jquery status
		i=0;
		while(i!=10){
	
			Boolean result= (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			System.out.println(result);
			if(result )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
	

	public void wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
