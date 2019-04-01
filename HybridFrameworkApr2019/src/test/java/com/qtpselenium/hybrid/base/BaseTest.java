package com.qtpselenium.hybrid.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.qtpselenium.hybrid.util.Xls_Reader;

public class BaseTest {
	
	public Properties envProp;
	public Properties prop;// environment. properties file  
	public Xls_Reader xls;
	

	@BeforeTest
	public void init(){
		prop= new Properties();
		envProp=new Properties();
		System.out.println("Initialization in init method before test method of base test");
		try {
			
			FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//env.properties");
			prop.load(fs);
			String envvalue=(prop.getProperty("env"));
			
			FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+envvalue+".properties");
			envProp.load(fp);
			System.out.println(envProp.getProperty("url"));
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//initialise the xls file
		xls= new Xls_Reader(envProp.getProperty("suitea_xls"));
		
	}
	
	
	
}
