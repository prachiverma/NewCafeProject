package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testcompany.project.Projectcafe.BasePg;


public class LaunchPage extends BasePg{
	
	
	public LaunchPage(WebDriver driver)
	{
		super(driver);
	}
	
	    public LoginPage gotoLoginPage(String url)
    {
    	//code to Maximize the window

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get(url);
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
