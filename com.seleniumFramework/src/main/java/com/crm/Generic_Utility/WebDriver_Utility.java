package com.crm.Generic_Utility;


import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class WebDriver_Utility {
	
	
	
	
	/**
	 * wait for page to load before identifying any synchronized in DOM
	 * param driver
	 * @
	 */
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * its an Explicitly wait for page to be loaded & available in GUI
	 * @param driver
	 * 
	 * @param PartialPageURL
	 */
    public void waitForElementToBeClickable(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    /**
     * used to wait for element to be clickable in GUI and check for specific element for every 500 millieconds
     * 
     */
    public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
    {
    	FluentWait wait=new FluentWait(driver);
    	wait.pollingEvery(Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(Element));
    }
    /**
     * used to switch to any window based on window title
     * @param driver
     * @param PartialWindowTitle
     * @author surya
     */
    public void switchToWindow(WebDriver driver,String PartialWindowTitle)
    {
    	Set<String> set=driver.getWindowHandles();
    	 java.util.Iterator<String> it = set.iterator();
    	
    	while(it.hasNext())
    	{
    		String wid=it.next();
    		driver.switchTo().window(wid);
    		String CurrentWindowTitle=driver.getTitle();
    		if(CurrentWindowTitle.contains(PartialWindowTitle))
    		{
    			break;
    		}
    	}
    }
    
    
    /**
     * used to switch to Alert window & click on ok button
     * @param driver
     * @author surya
     * 
     * 
     */public void switchToAlertWindowAndAccept(WebDriver driver,String expectedMsg)
     {
    	 Alert alt=driver.switchTo().alert();
    	 if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
    	 {
    		 System.out.println("Alert message is verified");
    	 }
    	 alt.accept();
     }
     
    /**
     * used to switch to Alert window& click on cancle button
     * @param driver
     * @author surya
     */
     public void switchToAlertWindowAndCancle(WebDriver driver,String expectedMsg)
     {
    	 Alert alt=driver.switchTo().alert();
    	 if(alt.getText().equals(expectedMsg))
    	   {
    		System.out.println("Alert message is verified");
    		}
    	else
    	{
    		System.out.println("Alert message is not verified");
    	}
    	alt.dismiss();
     }
     
     /**
      * used to switch to frame window based on index 
      * @param driver
      * @param index
      * @author surya
      */
     public void switchToFrame(WebDriver driver,int index)
     {
    	 driver.switchTo().frame(index);
     }
     
     /**
      * used to switch to frame window based on id or name attribute
      * @param driver
      * @param id_name_attribute
      */
     
     public void switchToFrame(WebDriver driver, String id_name_attribiute)
     {
    	 driver.switchTo().frame("id_name_attribute");
     }
     /**
      * used to select the value from the dropdown based on index
      * @param driver
      * @param index
      */
     public void select (WebElement element, int index)
     {
    	 Select sel=new Select(element);
     }
     /**
      * used to select the value from the dropdown based on the value/available in GUI
      * @param element
      * @param value
      */
     public void select (WebElement element,String text)
     {
    	 Select sel=new Select(element);
    	 sel.selectByVisibleText(text);
     }
     /**
      * used to place mouse cursor on specified element
      * @param driver
      * @param element
      */
     public void mouseOverOnElement(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     /**
      * used to right click on specified element
      * @param driver
      * @param element 
      */
     public void rightClickOnElement(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick(element).perform();
     }
     /**
      * 
      * @param driver
      * @param javascript
      */
     public void executeJavaScript(WebDriver driver,String javascript)
     {
    	 JavascriptExecutor jse=(JavascriptExecutor)driver;
    	 jse.executeScript(javascript, null);
     }
     
     public void waitAndClick(WebElement element) throws InterruptedException
     {
    	 int count=0;
    	 while(count<20)
    	 {
    		 try
    		 {
    			 element.click();
    			 break;
    		 }catch(Throwable e) {
    			 Thread.sleep(2000);
    			 count++;
    		 }
    	 }
     }
     /**
      * pass enter key appertain in to browser
      * @param driver
      * @author surya
      */
     public void passEnterKey(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.sendKeys(Keys.ENTER).perform();
     }
     }

