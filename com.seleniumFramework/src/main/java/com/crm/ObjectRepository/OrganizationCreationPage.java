package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage {

	// Initialization
	
	public OrganizationCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Declaration
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationImage;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	// getter methods

	/**
	 * @return the createOrganizationImage
	 */
	public WebElement getCreateOrganizationImage() {
		return createOrganizationImage;
	}

	/**
	 * @return the organizationNameTextField
	 */
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	// Business logics
	
	public void createOrganization()
	{
		createOrganizationImage.click();	
	}
	
	public void organizationName(String data)
	{
		organizationNameTextField.sendKeys(data);
	}
	
	public void saveButton()
	{
		saveButton.click();
	}
	
}
