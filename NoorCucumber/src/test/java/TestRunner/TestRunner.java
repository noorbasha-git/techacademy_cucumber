package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;






@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber"},
		features = {"C:\\Users\\noorb\\eclipse-workspace\\NoorCucumber\\src\\test\\java\\Feature\\login.feature"},
		glue={"com.porta.step"},
		monochrome = true,
		dryRun = false)
public class TestRunner{

}