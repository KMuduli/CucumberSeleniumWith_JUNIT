/**
 * 
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @author Kalia Muduli
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver) {
		this.driver=rdriver;
	//	PageFactory.initElements(rdriver, this);
		
		AjaxElementLocatorFactory ajaxFactory=new AjaxElementLocatorFactory(rdriver,30);
		PageFactory.initElements(ajaxFactory, this);
	}
	
	@FindBy(xpath="//span[@class=\"user-actions-ico\"]/*[local-name()='svg']")
	//  @CacheLookup
	   private WebElement svg_login_icon;
	
	@FindBy(xpath="//a/span[contains(text(),'Log in')]")
       private WebElement login_link;
	
	@FindBy(name="Username")
	  private WebElement txt_username;
	
	@FindBy(name="Password")
	  private WebElement txt_password;
	
	@FindBy(xpath="(//input[@class='btn blue-button'])[2]")
	   private WebElement btn_login;
	
	
	public void navigateToLoginPage() {
		svg_login_icon.click();
		login_link.click();
	}
	public void enterUsername(String username) {
		  txt_username.sendKeys(username);
	}
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}	
	public void clickLoginButton() {
		btn_login.click();
	}
	

}
