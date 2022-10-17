package practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingTicket {
	public static void main(String[]args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("C:\\Users\\USER\\Documents\\Common_DataMMT.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		driver.get(URL);
		driver.findElement(By.className("searchCity")).click();
		Random r=new Random();
		int RanNum=r.nextInt(1000);
		FileInputStream fis1=new FileInputStream("Book4.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("sheet1");
		Row row=sh.getRow(1);
		Cell cel=row.getCell(0);
		String data=cel.getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(data);
		driver.findElement(By.className("searchToCity")).click();
		FileInputStream fis2=new FileInputStream("Book4.xlsx");
		Workbook book1=WorkbookFactory.create(fis2);
		Sheet sh1=book1.getSheet("sheet1");
		Row row1=sh1.getRow(0);
		Cell cel1=row1.getCell(0);
		String data1=cel1.getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(data1);
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String date=driver.findElement(By.xpath("//div[text()='October 2022']")).getText();
		driver.findElement(By.xpath("(//p[text()='5'])[2]")).click();
	//	Thread.sleep(2000);
	//	String month1= "October 2022";
	//	String date1= "5";
	//	WebElement data3=driver.findElement(By.xpath("//div[text()='"+month1+"']" +
	//	  "/ancetor::div[@class='DayPicker-Month']/descendent::p[text()='"+date1+"']"));
	//	data3.click();
		driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();
		driver.findElement(By.xpath("(//p[text()='15'])[1]")).click();
		driver.findElement(By.xpath("//div[@data-cy='flightTraveller']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();
		driver.findElement(By.xpath("//li[@data-cy='infants-2']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
	}

}
