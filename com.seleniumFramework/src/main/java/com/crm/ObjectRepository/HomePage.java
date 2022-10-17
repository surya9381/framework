package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this); 
	}
	
	// Declaration
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLinkText;
	
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="More")
	private WebElement moreLinkText;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLinkText;
	
	//getter methods

	/**
	 * @return the organizationLinkText
	 */
	public WebElement getOrganizationLinkText() {
		return organizationLinkText;
	}

	/**
	 * @return the productLinkText
	 */
	public WebElement getProductLinkText() {
		return productLinkText;
	}

	/**
	 * @return the moreLinkText
	 */
	public WebElement getMoreLinkText() {
		return moreLinkText;
	}

	/**
	 * @return the campaignLinkText
	 */
	public WebElement getCampaignLinkText() {
		return campaignLinkText;
	}
	
	// Business logics
	
	public void home()
	{
		organizationLinkText.click();
		productLinkText.click();
		moreLinkText.click();
		campaignLinkText.click();
	}
}
	
	
	
	
	
	


