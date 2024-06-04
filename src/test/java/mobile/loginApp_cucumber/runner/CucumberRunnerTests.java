package mobile.loginApp_cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/loginApp_feature"}, plugin = {}, glue = "mobile.loginApp_cucumber.definitions")
public class CucumberRunnerTests  extends AbstractTestNGCucumberTests {
}
