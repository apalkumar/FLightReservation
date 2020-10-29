package com.BlzDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BlzDemo.base.TestBase;
public class pgBlzDemo_Purchase extends TestBase {


	@FindBy(xpath = "//input[@id='inputName']")
	public WebElement txtName;

	@FindBy(xpath = "//input[@id='address']")
	public WebElement txtAddress;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement txtCity;

	@FindBy(xpath = "//input[@id='state']")
	public WebElement txtState;

	@FindBy(xpath = "//input[@id='zipCode']")
	public WebElement txtZipCode;

	@FindBy (xpath = "//Select[@id ='cardType']")
	public WebElement dropCardType;
	//	public Select dropdownCardType;

	@FindBy(xpath = "//input[@id='creditCardNumber']")
	public WebElement txtCreditCardNumber;

	@FindBy(xpath = "//input[@id='creditCardMonth']")
	public WebElement txtMonth;

	@FindBy(xpath = "//input[@id='creditCardYear']")
	public WebElement txtYear;

	@FindBy(xpath = "//input[@id='nameOnCard']")
	public WebElement txtNameonCard;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement btnPurchaseFlight;

	public pgBlzDemo_Purchase()
	{
		PageFactory.initElements(driver, this);


	}

}
