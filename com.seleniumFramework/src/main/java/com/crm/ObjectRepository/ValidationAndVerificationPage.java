package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

@FindBy(css="span.dvHeaderText")
private WebElement actualOrganizationData;
public WebElement getActualOrganizationData() {
	return actualOrganizationData; 
	}
public void organizationValidation(WebDriver driver,String data) {
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
