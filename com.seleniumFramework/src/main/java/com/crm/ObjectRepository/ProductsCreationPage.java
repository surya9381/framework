package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsCreationPage {
	
	// Initialization
	
	public ProductsCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Declaration
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductImage;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	// getter methods
	
	/**
	 * @return the createProductImage
	 */
	public WebElement getCreateProductImage() {
		return createProductImage;
	}

	/**
	 * @return the productNameTextField
	 */
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	// business logics
	
	public void createProduct()
	{
		createProductImage.click();
	}
	
	public void productName(String data)
	{
		productNameTextField.sendKeys(data);
	}
	
	public void saveButton()
	{
		saveButton.click();
	}
	
	
}
