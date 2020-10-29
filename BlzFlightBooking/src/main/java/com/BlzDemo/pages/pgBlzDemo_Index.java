package com.BlzDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BlzDemo.base.TestBase;

public class pgBlzDemo_Index extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'destination of the week! The Beach!')]")
	public WebElement lnkdestoftheweek;

	@FindBy(xpath = "//input[@value='Find Flights']")
	public WebElement btnFindFlights;

	@FindBy (xpath = "//Select[@name ='fromPort']")
	public WebElement drpdwnfromport;
	public Select drpdwndeparture;

	@FindBy (xpath = "//Select[@name ='toPort']")
	public WebElement drpdwntoPort;
	public Select drpdwndestination;

	public pgBlzDemo_Index()
	{
		PageFactory.initElements(driver, this);
		drpdwndeparture = new Select(drpdwnfromport);
		drpdwndestination = new Select(drpdwntoPort);
	}



}
