package com.BlzDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BlzDemo.base.TestBase;

public class GoogleAnalyticsSolutionPage extends TestBase {


	@FindBy(xpath = "//a[contains(text(),'Self Help')]")
	WebElement linkSelfHelp;

	@FindBy(xpath="//a[contains(text(),'How to embed flows in my website or application?')]")
	WebElement linkHowToEmbedFlows;

	@FindBy(xpath="//a[contains(text(),'embed')]")
	WebElement linkEmbed;

	@FindBy(xpath="//a[contains(text(),'slideshow')]")
	WebElement toolTipslideshow;

	@FindBy(xpath = "//a[@class='WFMAKB ico-arrow-circle-right WFMAOY WFMANY']")
	WebElement linkRightArrow;

	@FindBy(xpath = "//a[@class='WFMAKB WFMACB' and text()='close']")
	WebElement linkClose;

	@FindBy(xpath="//a[text()='INSTALL EDITOR']")
	WebElement linkInstallEdtior;


	public boolean verifySelfHelplink()
	{
		return linkSelfHelp.isDisplayed();
	}

	public void clickSelfHelplink()
	{
		linkSelfHelp.click();
	}

	public boolean verifyHowToEmbedFlows()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return  wait.until(ExpectedConditions.visibilityOf(linkHowToEmbedFlows)).isDisplayed();	
	}

	public void clickHowToEmbedFlows()
	{
		linkHowToEmbedFlows.click();
	}

	public boolean verifytoolTipslideshow()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return  wait.until(ExpectedConditions.visibilityOf(toolTipslideshow)).isDisplayed();	
	}

	public void clicktoolTipslideshow()
	{
		toolTipslideshow.click();
	}

	public boolean verifylinkEmbed()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return  wait.until(ExpectedConditions.visibilityOf(linkEmbed)).isDisplayed();	
	}

	public void clickEmbed()
	{
		linkEmbed.click();
	}

	public boolean verifylinkRightArrow()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return  wait.until(ExpectedConditions.visibilityOf(linkRightArrow)).isDisplayed();	
	}

	public void clicklinkRightArrow()
	{
		linkRightArrow.click();
	}

	public boolean verifylinkClose()
	{	
		return  linkClose.isDisplayed();	
	}

	public void clicklinkClose()
	{
		linkClose.click();
	}
	public boolean verifylinkInstallEdtior()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return  wait.until(ExpectedConditions.visibilityOf(linkInstallEdtior)).isDisplayed();	
	}

	public GoogleAnalyticsSolutionPage()
	{
		PageFactory.initElements(driver, this);
	}

}
