package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateParameter {
	@Test
	public void createParameter()
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

}
}
