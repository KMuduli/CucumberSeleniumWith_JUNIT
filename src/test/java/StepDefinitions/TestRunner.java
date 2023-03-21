/**
 * 
 */
package StepDefinitions;
/**
 * @author Kalia Muduli
 *
 */
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"},
  monochrome = true,
  plugin = {"pretty", "html:target/HtmlReports/HtmlReports.html","json:target/JsonReports/Report.json","junit:target/JunitReports/Report.xml"}
 // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//Jai Maharastra
)

public class TestRunner {

}
