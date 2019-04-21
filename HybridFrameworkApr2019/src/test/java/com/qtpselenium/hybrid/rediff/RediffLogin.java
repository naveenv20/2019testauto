package com.qtpselenium.hybrid.rediff;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.util.Constants;
import com.qtpselenium.hybrid.util.DataUtil;

public class RediffLogin extends BaseTest {
	
@Test(dataProvider="getData")
	
	public void redlogintest(Hashtable<String, String> data) throws Exception{
		
		
		test.log(Status.INFO, "starting");

		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Test Case configured as No: "+ testName);
			throw new SkipException("Run mode is No");
		}
		
		System.out.println("Running Login test GAP ");	
		
		ds.executeKeywords(testName, xls, data);
}

}
