package com.BlzDemo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BlzDemo.base.TestBase;

public class pgBlzDemo_Confirmation extends TestBase {

	@FindBy(xpath = "//body//h1")
	public static WebElement txtThankYouForYourPurchaseToday;

	@FindBy(xpath = "//table//tr")
	public static List<WebElement> tblConfimationRowcnt;

	@FindBy(xpath = "//table//th")
	public static List<WebElement> tblConfimationColcnt;

	public pgBlzDemo_Confirmation()
	{
		PageFactory.initElements(driver, this);
	}

}
