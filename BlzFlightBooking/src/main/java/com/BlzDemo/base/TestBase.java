package com.BlzDemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BlzDemo.util.TestUtil;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;


	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\BlzDemo\\config\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initizatalion() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Webdriver\\chromedriver.exe");
			driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getexcelPath() {
//		String FilePath = System.getProperty("user.dir")+"\\TestData\\Data.xlsx";
		String FilePath = prop.getProperty("TestDataPath");;
		return FilePath;
	}

}
