package com.qtpselenium.hybrid.driver;

import java.util.Hashtable;

import com.qtpselenium.hybrid.util.Xls_Reader;

public class DriverScript {




public void executeKeywords (String testName, Xls_Reader xls, Hashtable<String, String> data) {
	int rows=xls.getRowCount("Keywords");
System.out.println("num of rows "+ rows);


for(int rNum=2;rNum<=rows;rNum++) {
String tcid=xls.getCellData("Keywords", "TCID", rNum);
if(tcid.equals(testName)) {
String keyword=xls.getCellData("Keywords", "Keyword", rNum);
String objectkey=xls.getCellData("Keywords", "Object", rNum);
String datakey=xls.getCellData("Keywords", "Data", rNum);
String datavalue=data.get(datakey);
System.out.println(tcid+"--"+keyword+"--"+objectkey+"--"+datakey+"--"+datavalue+"--");


}
}
}
	

}
