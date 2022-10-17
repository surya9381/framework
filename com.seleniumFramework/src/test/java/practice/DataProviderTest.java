package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="dataprovider_test")
	public void bookTickets(String src,String dst)
	{
		System.out.println("book tickets from "+src+","+dst+"");
	}
	@DataProvider
	public Object [][] dataprovider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Banglore";
		objArr[0][1]="goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="manglore";
		
		objArr[3][0]="Banglore";
		objArr[3][1]="kerala";
		
		objArr[4][0]="Banglore";
		objArr[4][1]="mumbai";
		return objArr;
	}
	
	

}
