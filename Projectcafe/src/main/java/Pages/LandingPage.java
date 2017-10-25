package Pages;

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
public class LandingPage extends BasePg
{
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}

    @FindBy(linkText = "Create")
    private WebElement lnk_Create; 
        
    public CreatePage create_Clk()
    {
    	lnk_Create.click();
    	return PageFactory.initElements(driver, CreatePage.class);
    }
    
}
