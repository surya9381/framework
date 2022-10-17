package com.crm.Campaign;



import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_Utility;
import com.crm.Generic_Utility.Java_Utility;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;




public class CreateCampaignTest extends BaseClass {   
	@Test
	public void createCampaign() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
     
        HomePage home=new HomePage(driver);
		home.getMoreLinkText().click();
		home.getCampaignLinkText().click();
		//	driver.findElement(By.linkText("More")).click(); 
		//	driver.findElement(By.name("Campaigns")).click();
		
		CreateCampaignPage campaign=new CreateCampaignPage(driver);
		
		campaign.getCreateCampaignImage().click();
	//		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		Java_Utility jlib=new Java_Utility();
		int RanNum=jlib.getRandom();
		
		Excel_Utility elib=new Excel_Utility();
		String data=elib.getDataFromExcel("sheet1", 0, 0)+RanNum;
		
		campaign.getCampaignNameTextField().sendKeys(data);
	//	driver.findElement(By.name("campaignname")).sendKeys(data);
		
		campaign.getSaveButton().click();
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData=driver.findElement(By.className("dvHeaderText")).getText();
		if(actData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	
	}

}
