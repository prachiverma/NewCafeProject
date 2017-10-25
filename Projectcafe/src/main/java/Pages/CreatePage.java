package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcompany.project.Projectcafe.BasePg;

import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class CreatePage extends BasePg
{
	public CreatePage(WebDriver driver)
	{
		super(driver);
	}
	
    @FindBy(xpath = "//input[contains(@ng-model, 'firstName')]")
    private WebElement firstNameTxt;
    
    @FindBy(xpath = "//input[contains(@ng-model, 'lastName')]")
    private WebElement lastNameTxt;
    
    @FindBy(xpath = "//input[contains(@ng-model, 'startDate')]")
    private WebElement startDateTxt;
    
    @FindBy(xpath = "//input[contains(@ng-model, 'email')]")
    private WebElement emailTxt;
    
    @FindBy(xpath = "//button[@type = 'submit'][2]")
    private WebElement addBtn; 
    
    @FindBy(xpath = ".//ul[@id='sub-nav'][@ng-show ='isCreateForm']/li/a")
    private WebElement cancelBtn; 
    
    @FindBy(xpath = "//div[@id='employee-list-container']")
    private WebElement employeeListContainer;
    
    @FindBy(xpath = "//a[@id='bEdit']")
    private WebElement editBtn; 
    
    @FindBy(xpath = "//a[@id='bDelete']")
    private WebElement deleteBtn;
    
    List<WebElement> employeelistCount;
        
    public void createItem(String fName, String lName, String startDate, String email)
    {
    	//Code to click on menu items and to verify that pages are successfully loaded
    	firstNameTxt.sendKeys(fName);
    	lastNameTxt.sendKeys(lName);
    	startDateTxt.sendKeys(startDate);
    	emailTxt.sendKeys(email);
    	scroll();
    	addBtn.click();    	
    }

    public void verifyTextPresent(String expectedtext) throws InterruptedException
    {
    	//code to get the text of all list elements
        employeelistCount = employeeListContainer.findElements(By.tagName("li"));
        System.out.println("Employee List size is: " +employeelistCount.size());       

    	for(int i =0; i<employeelistCount.size();i++)
    	{    		
    		String actualtext = employeelistCount.get(i).getText();
    		boolean condition = actualtext.equals(expectedtext);
    		Assert.assertFalse("Created text not present", condition);    		
    	} 
    }
   
    public EditPage EditItem(String text) throws InterruptedException
    {

    	//Code to get the text of all list elements
       employeelistCount = employeeListContainer.findElements(By.tagName("li"));
       System.out.println("Employee List size is: " +employeelistCount.size());        

    	for(int i =0; i<employeelistCount.size();i++)
    	{    		
    		String value = employeelistCount.get(i).getText();
    		if(value.equalsIgnoreCase(text))
    		{
    			//scroll();
    			employeelistCount.get(i).click();
    			editBtn.click();
    			break;
    		}
    	} 
    	
    	return PageFactory.initElements(driver, EditPage.class);
    }
    
    public void DeleteItem(String text) throws InterruptedException
    {
    	//Code to get the text of all list elements
    	employeelistCount = employeeListContainer.findElements(By.tagName("li"));
       	for(int i =0; i<employeelistCount.size();i++)
       	{    		
       		String value = employeelistCount.get(i).getText();
       		if(value.equalsIgnoreCase(text))
       		{
       			employeelistCount.get(i).click();
       			deleteBtn.click();
       			break;
       		}
       	} 
   	
    	Alert alert = driver.switchTo().alert();    	
    	alert.accept();
    }
    
    
    public void clkCancel()
    {
    	cancelBtn.click();  

    }
}
