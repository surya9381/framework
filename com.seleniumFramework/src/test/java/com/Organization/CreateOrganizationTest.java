package com.Organization;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_Utility;
import com.crm.Generic_Utility.File_Utility;
import com.crm.Generic_Utility.Java_Utility;
import com.crm.Generic_Utility.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationCreationPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {
	
	
	@Test(retryAnalyzer=com.crm.Generic_Utility.RetryAnalyser.class)
	public void createOrganization()throws IOException, InterruptedException {
	
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	
    	HomePage home=new HomePage(driver); 
		home.getOrganizationLinkText().click(); 
	//	driver.findElement(By.linkText("Organizations")).click();
		
		
		OrganizationCreationPage organize=new OrganizationCreationPage(driver);
		
		organize.getCreateOrganizationImage().click();
	//	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Java_Utility jlib=new Java_Utility();
		int RanNum=jlib.getRandom();
		
		Excel_Utility elib=new Excel_Utility();
		String data=elib.getDataFromExcel("sheet1", 0, 0)+RanNum;
		
		organize.getOrganizationNameTextField().sendKeys(data);
	//	driver.findElement(By.name("accountname")).sendKeys(data);
		
	
		
		organize.getSaveButton().click();
	
		//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
	//	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	//	validate.organizationValidation(driver,data);
		
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	    ValidationAndVerificationPage validate=new  ValidationAndVerificationPage(driver);
	   validate.organizationValidation(driver, data);
	/*	String actData1=driver.findElement(By.className("dvHeaderText")).getText();
	    if(actData1.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}  */    
		}

}
