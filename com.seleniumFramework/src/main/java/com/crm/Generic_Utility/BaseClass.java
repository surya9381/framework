package com.crm.Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
 //   static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun=true)
	public void BS()
	{
		System.out.println("data base connection"); 
	}
	@BeforeTest(alwaysRun=true)
	public void BT()
	{
		System.out.println("Execute in parallel mode");
	}
//	@Parameters("BROWSER")
    @BeforeClass(alwaysRun=true)
//    public void launchBrowser(String BROWSER) throws IOException {
  	 public void launchBrowser() throws IOException  {
    	File_Utility flib=new File_Utility ();

    	
    	String Browser=flib.getPropertyKeyValue1("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	//	driver=sDriver;
    	System.out.println("browser is launched");
    }
    @BeforeMethod(alwaysRun=true)
    public void loginToApplication() throws IOException
    {
    	File_Utility flib=new File_Utility();
        String URL=flib.getPropertyKeyValue1("url");
		String UserName=flib.getPropertyKeyValue1("un");
		String PassWord=flib.getPropertyKeyValue1("pw");
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.login(UserName, PassWord);
    	System.out.println("Successfully logged in");
    }
    @AfterMethod(alwaysRun=true)
    public void logout()
    {
    	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
    	System.out.println("Successfully loged out");
    }
    @AfterClass(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.close();
    	System.out.println("browser is closed");
    }
    @AfterTest(alwaysRun=true)
    public void AT()
    {
    	System.out.println("Executed successfully");
    }
    @AfterSuite(alwaysRun=true)
    public void AS()
    {
    	System.out.println("close database");
    }  
}
