package com.qtpselenium.hybrid.keywords;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class AppKeywords extends GenericKeywords{

	
	
	public void validateLogin()  {
		test.log(Status.INFO,"Inside the validate login function");	
		if(isElementPresent("logout_xpath")){
			test.log(Status.INFO,"Login Success");	
		}
		else{
			test.log(Status.INFO,"Not able to login");
			reportFailure("Login Failed");
		}
		
	}
	
	public void defaultlogin() {
		String username="";
		String password="";
		username=data.get("Username");
		password=data.get("Password");
		test.log(Status.INFO,"Inside the default login function");	
		getelement("money_lnk_xpath").click();
		getelement("signin_lnk_xpath").click();
		getelement("login_tb_xpath").sendKeys(username);
		getelement("login_ctn_btn_xpath").click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getelement("pwd_tb_xpath")));
		getelement("pwd_tb_xpath").sendKeys(password);
		getelement("pwd_cn_btn_xpath").click();
		wait.until(ExpectedConditions.invisibilityOf(getelement("pwd_tb_xpath")));
		
		
	}
	
	public void redmoney_login_succ() {
//		String Expectedheader=data.get(datakey);
//		String actualheader=gettext();
//		if(Expectedheader.equals(actualheader)) {
//			test.log(Status.PASS, "Login success and header match");
//		}
//			else {
//			reportFailure("Login is a faiure ,Expected is :"+Expectedheader +" and actual is : "+actualheader);
//			
//		}

       if(isElementPresent(objectkey)){
    	   test.log(Status.PASS, "Able to see the my portfolio section");
       }
       else{
    	   reportFailure("Login failure");
       }
	
	
	}
		
		public void verifyportfolio() {
			
			test.log(Status.INFO, "Checking if the portfolio is created or not "+data.get(datakey));
			waitforinvisibilityofelement("create_PF_BTN_id");
			Select s= new Select(getelement(objectkey));
			String text=s.getFirstSelectedOption().getText();	
			test.log(Status.INFO, "go the value as :"+text);
			if(!text.equalsIgnoreCase(data.get(datakey)))
				reportFailure("value in DP did not matched");	
		}
		
}
