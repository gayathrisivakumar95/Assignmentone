package Assignment_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/Signup/Signup.feature"},
glue= {"Assignment_Stepdefinition"},
dryRun=false,
monochrome=true,
strict=true,
plugin = {"html:testoutput/Gayathri.html","junit:testoutput/Gayathri.xml","json:testoutput/Gayathri.json"}
)
public class Assignment_Runner extends AbstractTestNGCucumberTests {

}
