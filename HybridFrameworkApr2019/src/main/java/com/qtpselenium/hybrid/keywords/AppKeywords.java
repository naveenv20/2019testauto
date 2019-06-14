package com.qtpselenium.hybrid.keywords;

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
		test.log(Status.INFO,"Inside the default login function");	
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
		
		
		
}
