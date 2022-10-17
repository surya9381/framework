package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	// Initialization
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Declaration
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignImage;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectImage;

	// getter methods
	
	/**
	 * @return the createCampaignImage
	 */
	public WebElement getCreateCampaignImage() {
		return createCampaignImage;
	}

	/**
	 * @return the campaignNameTextField
	 */
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * @return the selectImage
	 */
	public WebElement getSelectImage() {
		return selectImage;
	}

	/**
	 * @param selectImage the selectImage to set
	 */
	public void setSelectImage(WebElement selectImage) {
		this.selectImage = selectImage;
	}

	public void createCampaign()
	{
		createCampaignImage.click();
	}
	
	public void campaignName(String data)
	{
		campaignNameTextField.sendKeys(data);
	}
	
	public void saveButton()
	{
		saveButton.click();
	}
	
	public void setImage() {
		selectImage.click();
	}
}
