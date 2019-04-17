package com.qtpselenium.hybrid.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qtpselenium.hybrid.driver.DriverScript;
import com.qtpselenium.hybrid.reports.ExtentManager;
import com.qtpselenium.hybrid.util.DataUtil;
import com.qtpselenium.hybrid.util.Xls_Reader;

public class BaseTest {
	
	public Properties envProp;
	public Properties prop;// environment. properties file  
	public Xls_Reader xls;
	public String testName;
	public DriverScript ds;
	public ExtentReports rep;
	public ExtentTest test;
	
	
	@BeforeTest
	public void init(){
		System.out.println("****** class name: "+ this.getClass().getSimpleName());
		testName=this.getClass().getSimpleName();
		
		//System.out.println("******"+this.getClass().getPackage().getName());
		String arr[]=this.getClass().getPackage().getName().split("\\.");
		String suiteName=(arr[arr.length-1]);
		System.out.println("****** suite name: "+ suiteName);
		prop= new Properties();
		envProp=new Properties();
		System.out.println("Initialization in init method before test method of base test");
		try {
			
			FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//env.properties");
			prop.load(fs);
			String envvalue=(prop.getProperty("env"));
			
			FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+envvalue+".properties");
			envProp.load(fp);
			System.out.println("#####"+envProp.getProperty("gap_url"));
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//initialise the xls file
		xls= new Xls_Reader(System.getProperty("user.dir")+"//src//test//resources//Sheets//"+ envProp.getProperty(suiteName+"_xls"));
		
		//initialise the driver script object
		ds=new DriverScript();
		//passing the envprop and prop object to driverscript object through getter and setter
		ds.setEnvProp(envProp);
		ds.setProp(prop);
		
	}
	
	@AfterMethod
	public void quit(){
		//quit the driver
		if(ds!=null)
		ds.quit();
		if(rep!=null){
			rep.flush();
		}
	}
	
	
	@BeforeMethod
	public void initTest(){
		rep=ExtentManager.getInstance(prop.getProperty("reportPath"));
		test=rep.createTest(testName);
		//passing the extent test object for logging to driverscript obj ,for logging stuff in that 
				ds.setTest(test);
	}
	
	@DataProvider
	public Object[][] getData(){
		System.out.println("Inside data provider");
		return DataUtil.getTestData(testName, xls);
	}
	
}
