/**
 * 
 */
package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @author Kalia Muduli
 *
 */
public class LoginSteps {
	
	WebDriver driver;
	LoginPage loginpage;

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		System.out.println("Step - user is on login page");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		loginpage=new LoginPage(driver);
		Thread.sleep(1000);
		loginpage.navigateToLoginPage();		
	//	Assert.assertTrue(false);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		System.out.println("Step - user enters username and password");
		Thread.sleep(1000);
		loginpage.enterUsername("KanhaAA");
		loginpage.enterPassword("Kanha@2005");		
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException  {
		System.out.println("Step - click on login button");
		Thread.sleep(1000);
		loginpage.clickLoginButton();
		Assert.assertTrue(false);
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Step - user is navigated to the home page");
	//	driver.quit();
			
	}
	
	
	@After
	public void addScreenshot() {
		System.out.println("After Tag");
		driver.quit();
	}
	
	@Before
	public void addScreenshota( ) {
		
		System.out.println("Before Tag");
	}
	

	@BeforeStep
	public void beforeStep() {
		System.out.println("BeforeStep Tag");
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		System.out.println("AfterStep Tag");
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "Image/png", scenario.getName());
		}	
	}


}
