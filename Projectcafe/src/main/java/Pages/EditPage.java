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
public class EditPage extends BasePg
{
	public EditPage(WebDriver driver)
	{
		super(driver);
	}
	

    
    @FindBy(xpath = "//div[@id='employee-list-container']")
    private WebElement employeeListContainer;
    
    @FindBy(xpath = "//button[@type = 'submit'][@ng-hide = 'isCreateForm']")
    private WebElement updateBtn;
    
    @FindBy(xpath = ".//ul[@id='sub-nav']/li/a[contains(@class, 'Back')]")
    private WebElement backBtn; 

    @FindBy(xpath = "//input[contains(@ng-model, 'lastName')]")
    private WebElement lastNameTxt;
    
    @FindBy(xpath = "//input[contains(@ng-model, 'firstName')]")
    private WebElement firstNameTxt;
    

    public String UpdateItem(String text) throws InterruptedException
    {
    	firstNameTxt.clear();
    	firstNameTxt.sendKeys(text); 
    	lastNameTxt.clear();
    	lastNameTxt.sendKeys(text);
    	String newfname = text + " " + text;
    	return newfname;
    }
    
    public CreatePage ClickUpdate(String text) throws InterruptedException
    {
    	updateBtn.click();
    	return PageFactory.initElements(driver, CreatePage.class);
    }
    
 
}
