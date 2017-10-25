package com.testcompany.project.Projectcafe;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePg {
	
	protected WebDriver driver;
	
	public BasePg(WebDriver driver)
	{
		this.driver = driver;
	}
    
    public void scroll()
    {    	
    	//code to scroll the page
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,350)", "");    	
    }


}
