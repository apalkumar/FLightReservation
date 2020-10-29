package com.BlzDemo.util;


import com.BlzDemo.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LONG_TIMEOUT = 35;
	public static long IMPLICT_WAIT = 25;

	public void switchtodefault()
	{
		
		driver.switchTo().defaultContent();
	}
	
	
	
}
