package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunParameter {
	@Test
	public void launchBrowser()
	{
		
		String Browser=System.getProperty("browser");
		System.out.println(Browser);
		WebDriver driver;
		
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
		String URL=System.getProperty("url");
		driver.get(URL);
		String UserName=System.getProperty("un");
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		String Password=System.getProperty("pw");
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("user_password")).click();
		}
}