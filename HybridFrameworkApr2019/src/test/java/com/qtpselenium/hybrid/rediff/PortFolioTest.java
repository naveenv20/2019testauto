package com.qtpselenium.hybrid.rediff;



import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.util.Constants;
import com.qtpselenium.hybrid.util.DataUtil;

public class PortFolioTest extends BaseTest {
	WebDriver driver;
	@Test(priority=1,dataProvider="getData")
	public void createPortfolioTest(Hashtable<String, String> data) throws InterruptedException{

		test.log(Status.INFO, "starting createPortfolioTest");

		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Test Case configured as No: "+ testName);
			throw new SkipException("Run mode is No");
		}
		
		System.out.println("Running Login test GAP ");	
		
		ds.executeKeywords(testName, xls, data);
		
		/*
		 *  createPortfolioTest		redmoney_login_succ	my_portfolio_header_xpath	login_succ_header	Y
createPortfolioTest		click	create_PF_id		N
createPortfolioTest		clear	PF_name_id		N
createPortfolioTest		type	PF_name_id	PF_Name	N
		click	create_PF_btn_id		N

		 * 
		 * 
		 * 
		 * my_portfolio_header_xpath=//*[@id="portfolioid"]
create_PF_id=createPortfolio
PF_name_id=create
create_PF_btn_id=createPortfolioButton
		 * 
		 */
}
	
	
	@Test(priority=2,dataProvider="getData")

	public void deletePortfolioTest(Hashtable<String, String> data) throws InterruptedException{
		
		test.log(Status.INFO, "starting createPortfolioTest");
		
		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Test Case configured as No: "+ testName);
			throw new SkipException("Run mode is No");
		}
		
		System.out.println("Running Login test GAP ");	
		
		ds.executeKeywords(testName, xls, data);
	}
}
