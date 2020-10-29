package com.BlzDemo.testcases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.BlzDemo.base.TestBase;
import com.BlzDemo.pages.pgBlzDemo_Confirmation;
import com.BlzDemo.pages.pgBlzDemo_Index;
import com.BlzDemo.pages.pgBlzDemo_Purchase;
import com.BlzDemo.pages.pgBlzDemo_Reserve;
import com.BlzDemo.util.TestUtil;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class BlzDemo extends TestBase {
	pgBlzDemo_Index oblzdemoindexpg;
	pgBlzDemo_Reserve oblzdemoreservepg;
	pgBlzDemo_Purchase oblzdemopurchasepg;
	pgBlzDemo_Confirmation oblzdemoconfirmationpg;
	TestUtil testUtil;
	public String sAirline;
	public String sDepartureCity;
	public String sDestinationCity;
	public String sPassngrName;
	public String sAddress;
	public String sCity;
	public String sState;
	public String sZipCode;
	public String sCcnum;
	public String sMonth;
	public String sYear;
	public String sNameOnCard;
	public String sTitle;
	public String testcasename = "Test1";
	public String sIdNumber;
	public String sMessage;
	public String[] arrId;

	public BlzDemo() {
		super();
	}

	@BeforeMethod
	public void stepUp() {
		initizatalion();
		oblzdemoindexpg = new pgBlzDemo_Index();
		oblzdemoreservepg =  new pgBlzDemo_Reserve();
		oblzdemopurchasepg = new pgBlzDemo_Purchase();
		oblzdemoconfirmationpg = new pgBlzDemo_Confirmation();
		testUtil = new TestUtil();
	}

	@Test
	public void verifyItinaryReservation() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

//		Get the Test Data Path
		String ExcelPath =  getexcelPath();

//		Establishing connection with Test Data excel file for fetching the Data
		Fillo fillo = new Fillo();
		Connection conn = null;
		try {
			conn = fillo.getConnection(ExcelPath);
			Recordset rsUser = conn.executeQuery("Select * from BlazeSheet where TestCaseName = '" + testcasename + "'");
			while(rsUser.next()) {
				if(rsUser.getField("Departure").isEmpty()) {
					System.out.println("There is no Data in field Departure");
					break;
				}else
				{
					sDepartureCity = rsUser.getField("Departure");
				}
				if(rsUser.getField("Destination").isEmpty()) {
					System.out.println("There is no Data in field Destination");
					break;
				}else
				{
					sDestinationCity = rsUser.getField("Destination");
				}
				if(rsUser.getField("PassngrName").isEmpty()) {
					System.out.println("There is no Data in field PassngrName");
					break;
				}else
				{
					sPassngrName = rsUser.getField("PassngrName");
				}
				if(rsUser.getField("Address").isEmpty()) {
					System.out.println("There is no Data in field Address");
					break;
				}else
				{
					sAddress = rsUser.getField("Address");
				}
				if(rsUser.getField("City").isEmpty()) {
					System.out.println("There is no Data in field City");
					break;
				}else
				{
					sCity  = rsUser.getField("City");
				}
				if(rsUser.getField("State").isEmpty()) {
					System.out.println("There is no Data in field State");
					break;
				}else
				{
					sState  = rsUser.getField("State");
				}
				if(rsUser.getField("ZipCode").isEmpty()) {
					System.out.println("There is no Data in field ZipCode");
					break;
				}else
				{
					sZipCode  = rsUser.getField("ZipCode");
				}
				if(rsUser.getField("Ccnum").isEmpty()) {
					System.out.println("There is no Data in field Credit Card Number");
					break;
				}else
				{
					sCcnum  = rsUser.getField("Ccnum");
				}
				if(rsUser.getField("Month").isEmpty()) {
					System.out.println("There is no Data in field Month");
					break;
				}else
				{
					sMonth  = rsUser.getField("Month");
				}
				if(rsUser.getField("Year").isEmpty()) {
					System.out.println("There is no Data in field Year");
					break;
				}else
				{
					sYear  = rsUser.getField("Year");
				}
				if(rsUser.getField("NameOnCard").isEmpty()) {
					System.out.println("There is no Data in field NameOnCard");
					break;
				}else
				{
					sNameOnCard   = rsUser.getField("NameOnCard");
				}

				if(rsUser.getField("AirlineName").isEmpty()) {
					System.out.println("There is no Data in field Airline");
					break;
				}else
				{
					sAirline   = rsUser.getField("AirlineName");
				}
				if(rsUser.getField("Title").isEmpty()) {
					System.out.println("There is no Data in field Title");
					break;
				}else
				{
					sTitle   = rsUser.getField("Title");
				}
				if(rsUser.getField("Message").isEmpty()) {
					System.out.println("There is no Data in shown in Message");
					break;
				}else
				{
					sMessage   = rsUser.getField("Message");
				}
			} 
		}catch (FilloException e) {
			e.printStackTrace();
		}

//	Entering the Data in Application's Fields
		try {
			oblzdemoindexpg.drpdwndeparture.selectByVisibleText(sDepartureCity);
			oblzdemoindexpg.drpdwndestination.selectByValue(sDestinationCity);
			oblzdemoindexpg.btnFindFlights.click();
			wait.until(ExpectedConditions.visibilityOf(oblzdemoreservepg.btnchoosethisflight)).isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();	
		}

		try {
			oblzdemoreservepg.selectFlightbyAirline(sAirline);
			wait.until(ExpectedConditions.visibilityOf(oblzdemopurchasepg.txtName)).isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			oblzdemopurchasepg.txtName.sendKeys(sPassngrName);
			oblzdemopurchasepg.txtAddress.sendKeys(sAddress);
			oblzdemopurchasepg.txtCity.sendKeys(sCity);
			oblzdemopurchasepg.txtState.sendKeys(sState);
			oblzdemopurchasepg.txtZipCode.sendKeys(sZipCode);
			oblzdemopurchasepg.txtCreditCardNumber.sendKeys(sCcnum);
			oblzdemopurchasepg.txtMonth.sendKeys(sMonth);
			oblzdemopurchasepg.txtYear.sendKeys(sYear);
			oblzdemopurchasepg.txtNameonCard.sendKeys(sNameOnCard);
			oblzdemopurchasepg.btnPurchaseFlight.click();
			wait.until(ExpectedConditions.visibilityOf(pgBlzDemo_Confirmation.txtThankYouForYourPurchaseToday)).isDisplayed();
			Assert.assertEquals(pgBlzDemo_Confirmation.txtThankYouForYourPurchaseToday.getText(), sMessage.trim(), "Ticket Purchase done");
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}

		List<WebElement> sRowCnt = pgBlzDemo_Confirmation.tblConfimationRowcnt;
		int iRowCnt = sRowCnt.size();
		for(int i=0;i<=iRowCnt;i++) {
			sIdNumber = sRowCnt.get(i).getText();
			if(sIdNumber.contains("Id")) {
				arrId = sIdNumber.split(" ");
				System.out.println("Itinary Id Found-->"+arrId[1]);
				break;
			}
		}
	}

	@Test
	public void verifydestinationOftheweek() throws InterruptedException
	{
		oblzdemoindexpg.lnkdestoftheweek.click();
		Assert.assertEquals(driver.getTitle(), sTitle.trim(),"Validate Title");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();

	}
}