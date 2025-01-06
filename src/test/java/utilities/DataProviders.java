package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path=".\\testData\\opencart-LoginData.xlsx"; //taking xl file from testData
		
		ExcelUtils xlutil=new ExcelUtils(path);		//creating an object for ExcelUtils
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];	//created 2dimension array which can extracts and stores test data from xl file
		for(int i=1; i<totalrows;i++) {	//1 read the data from xl storing in two dimensional array
			for(int j=0; j<totalcols; j++) {	//0 i is rows, j is col
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);	//1,0
			}
		}
		return logindata;	//returning 2 dimension array
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
	
}
