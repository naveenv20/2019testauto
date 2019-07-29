package com.qtpselenium.hybrid.rediff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.util.Constants;
import com.qtpselenium.hybrid.util.DataUtil;


public class AddDelStockTest_Module17 extends BaseTest{
	WebDriver driver;
	
	@Test(priority=1,dataProvider="getData")
	public void addStockTest(Hashtable<String, String> data) throws InterruptedException{
	
		test.log(Status.INFO, "starting createPortfolioTest");

		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Test Case configured as No: "+ testName);
			throw new SkipException("Run mode is No");
		}
		
		System.out.println("Running Login test GAP ");	
		
		ds.executeKeywords(testName, xls, data);
        
		
		/*
		int rNum=getRowWithCellData("Tata Steel");
		System.out.println("Row " + rNum);
		if(rNum==-1)
			Assert.fail("Could not find the Stock");
		*/
		
	}
	
	/*
	@Test(priority=2,dependsOnMethods={"addStockTest"})
	public void deleteStockTest(){
			int rNum=getRowWithCellData("Tata Steel Ltd.");
			driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+rNum+"]/td[1]")).click();
			driver.findElements(By.xpath("//input[@name='Delete']")).get(rNum-1).click();
			driver.switchTo().alert().accept();
			waitForPageToLoad();
			driver.switchTo().defaultContent();
			rNum=getRowWithCellData("Tata Steel Ltd.");
			System.out.println(rNum);
			Assert.assertEquals(rNum, -1);
	}
	*/
	
	
	
	
	
	
	

	
}
