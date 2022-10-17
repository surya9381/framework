package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider="dataprovider_test")
	public void companyDetails(String subject,String customernumber,String contactname) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("customerno")).sendKeys(customernumber);
		driver.findElement(By.name("contact_name")).sendKeys(contactname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.quit();
		Thread.sleep(2000);
		}
	@DataProvider
	public Object[][] dataprovider_test()
	{
	Object[][]objArr=new Object[3][3];
	objArr[0][0]="laptop";
	objArr[0][1]="123";
	objArr[0][2]="surya";
	
	objArr[1][0]="mobile";
	objArr[1][1]="234";
	objArr[1][2]="ravi";
	
	objArr[2][0]="radio";
	objArr[2][1]="345";
	objArr[2][2]="chinnu";
	return objArr;
	}

}
