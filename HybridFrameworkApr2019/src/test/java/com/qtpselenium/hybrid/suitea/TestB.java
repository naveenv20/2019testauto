package com.qtpselenium.hybrid.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.reports.ExtentManager;
import com.qtpselenium.hybrid.util.Constants;
import com.qtpselenium.hybrid.util.DataUtil;
//name of the java file should be same as the name in xls file
public class TestB extends BaseTest{

	
	@Test(dataProvider="getData")
	
	public void testb(Hashtable<String, String> data){
		
		ExtentReports rep=ExtentManager.getInstance(prop.getProperty("reportPath"));
		ExtentTest test=rep.createTest(testName);
		test.log(Status.INFO, "starting");
		rep.flush();
		
		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO))
			throw new SkipException("Run mode is No");
		
		
		System.out.println("Running test B");	
		
		ds.executeKeywords(testName, xls, data);
	}
	
	
}
