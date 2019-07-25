package com.qtpselenium.hybrid.rediff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.Test;

import com.qtpselenium.hybrid.base.BaseTest;


public class AddDelStockTest_Module17 extends BaseTest{
	WebDriver driver;
	
	@Test(priority=1)
	public void addStockTest() throws InterruptedException{
	
		
        WebElement e = driver.findElement(By.id("portfolioid"));
		Select s = new Select(e);
		s.selectByVisibleText("Ashi_29");
		//
		waitForPageToLoad();
		driver.findElement(By.id("addStock")).click();
		driver.findElement(By.id("addstockname")).sendKeys("Tata Steel Ltd");
		driver.findElement(By.xpath("//div[text()='Tata Steel Ltd.']")).click();
		
		driver.findElement(By.id("stockPurchaseDate")).click();
		selectDate("12/04/2017");
		driver.findElement(By.id("addstockqty")).sendKeys("100");
		driver.findElement(By.id("addstockprice")).sendKeys("500");
		driver.findElement(By.id("addStockButton")).click();
		waitForPageToLoad();
		//String text = driver.findElement(By.xpath("//table[@id='stock']/tbody/tr[1]/td[2]")).getText();
		//System.out.println(text);
		int rNum=getRowWithCellData("Tata Steel");
		System.out.println("Row " + rNum);
		if(rNum==-1)
			Assert.fail("Could not find the Stock");
		
		
	}
	
	
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
	
	public void wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void selectDate(String d){
		// day, month , year
		Date current = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date selected = sd.parse(d);
			String day = new SimpleDateFormat("dd").format(selected);
			String month = new SimpleDateFormat("MMMM").format(selected);
			String year = new SimpleDateFormat("yyyy").format(selected);
			System.out.println(day+" --- "+month+" --- "+ year);
			String desiredMonthYear=month+" "+year;
			
			while(true){
				String displayedMonthYear=driver.findElement(By.cssSelector(".dpTitleText")).getText();
				if(desiredMonthYear.equals(displayedMonthYear)){
					// select the day
					driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
					break;
				}else{
					
					if(selected.compareTo(current) > 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
					else if(selected.compareTo(current) < 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();

				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getRowWithCellData(String data){
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		for(int rNum=0;rNum<rows.size();rNum++){
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum=0;cNum<cells.size();cNum++){
				WebElement cell = cells.get(cNum);
				if(!cell.getText().trim().equals("") && data.contains(cell.getText()))
					return ++rNum;
			}
		}
		
		return -1;// not found
	}

	
}
