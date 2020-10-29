package com.BlzDemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BlzDemo.base.TestBase;
public class pgBlzDemo_Reserve extends TestBase {

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]/input[@value=\"Choose This Flight\"]")
	public WebElement btnchoosethisflight;


	@FindBy(xpath = "//table/tbody/tr")
	public static List<WebElement> tblRowCout;
	public int iRowct;

	@FindBy(xpath = "//table/tbody/tr[1]/td")
	public static List<WebElement> tblColCout;
	public int iColct;


	public pgBlzDemo_Reserve()
	{
		PageFactory.initElements(driver, this);
	}

	public int get_Rowcount()
	{
		iRowct = tblRowCout.size();
		return iRowct;
	}

	public int get_colcount()
	{
		iColct = tblColCout.size();
		return iColct;
	}
	
	public void selectFlightbyAirline(String sAirline) {

		try {
		if(sAirline.equals("Virgin America")) {
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/input")).click();
		}
		if(sAirline.equals("United Airlines")) {
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/input")).click();
		}
		if(sAirline.equals("Aer Lingus")) {
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]/input")).click();
		}
		if(sAirline.equals("Lufthansa")) {
			driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]/input")).click();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}