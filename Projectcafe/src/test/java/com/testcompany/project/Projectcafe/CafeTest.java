package com.testcompany.project.Projectcafe;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.*;
import Pages.CreatePage;
import Pages.EditPage;
import Pages.LandingPage;
import Pages.LaunchPage;
import Pages.LoginPage;

public class CafeTest {
	WebDriver driver;
	
	@BeforeTest()
	public void Init() {

		//Code to execute before test method to open new Mozila Firefox browser	
		driver = new FirefoxDriver();
	}
	
	@Test
	public void TestMethod() throws InterruptedException, IOException
	{	
		//creating object of ReadProperty file
		ReadPropertyFile data = new ReadPropertyFile();
		LaunchPage launchPage = PageFactory.initElements(driver,
				LaunchPage.class);
		
		//Create new instance of login page
		LoginPage loginPage = launchPage.gotoLoginPage(data.getValue("url"));
		
		//Login with valid credentials into the application
		Object page = loginPage.dologin(data.getUserName(), data.getPassword());
		if (page instanceof LoginPage)
			org.junit.Assert.fail("Test Case fail");
		else if (page instanceof CreatePage)
			System.out.println("Logged in successfully");
		LandingPage landingpage = (LandingPage) page;
		CreatePage createPage = landingpage.create_Clk();
		
		//Create new employee
		createPage.createItem(data.getValue("fname"),
				data.getValue("lname"),
				data.getValue("creationdate"),
				data.getValue("email"));
		
		//Verify newly added employee name is present on the list
		createPage.verifyTextPresent(data.getValue("fname"));
		createPage = landingpage.create_Clk();
		createPage.clkCancel();	
		
		//Create instance of edit page and editing the newly added employee name
		EditPage editPage = createPage.EditItem(data.getValue("fname") + " "+ data.getValue("lname"));
		
		//Store the name of updated employee in variable
		String Name = editPage.UpdateItem(data.getValue("newfname"));
		
		//Select the employee whose name was updated from the list of employees
		createPage = editPage.ClickUpdate(Name);
		
		//Delete the  employee
		createPage.DeleteItem(Name);
	}
	
	@AfterTest
	public void driverClose() {
		
		//Code to execute after test method to close all open browsers
		driver.quit();
	}
	
}
