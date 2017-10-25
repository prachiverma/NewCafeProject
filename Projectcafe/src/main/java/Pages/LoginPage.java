package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testcompany.project.Projectcafe.BasePg;


public class LoginPage extends BasePg{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	    
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement loginBtn; 
   
    @FindBy(xpath = "//form[@id='login-form']/fieldset/label[1]/input")
    private WebElement userNameTxt;
    
    @FindBy(xpath = "//form[@id='login-form']/fieldset/label[2]/input")
    private WebElement passwordTxt;    
   
     
      public Object dologin(String UserName, String Password)
    {	
    	  //Code for Login into the application
    	  userNameTxt.sendKeys(UserName);
    	  passwordTxt.sendKeys(Password);
    	  loginBtn.click();
    	boolean loginSuccess = true;
    	if(loginSuccess==true)
    		return PageFactory.initElements(driver, LandingPage.class);
    	else
    		return PageFactory.initElements(driver, LoginPage.class);  	
    		
    }

}
