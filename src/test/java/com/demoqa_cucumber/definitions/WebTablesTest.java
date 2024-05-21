package com.demoqa_cucumber.definitions;

import com.demoqa_cucumber.pageObject.WebTables;
import com.demoqa_cucumber.pojo.RegisterUser;
import com.demoqa_cucumber.utils.Env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebTablesTest {
    static Logger log = LogManager.getLogger(WebTablesTest.class.getName());
    long implicitlyWait;
    @When("User go to WebTables page")
    public void openWebTablesPage(){
        BaseClass.getDriver().get(Env.getProperty("webTablesUrl"));
        BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }

    @And("User enter registration form")
    public void enterRegistrationForm(){
        WebTables webTables = new WebTables(BaseClass.getDriver());
        RegisterUser user =new RegisterUser();
        user.generateRegisterUser();
        webTables.registration(user);
    }
    @Then("Verify added data")
    public void verifyAddedData () throws InterruptedException{
        WebTables webTables = new WebTables(BaseClass.getDriver());
        RegisterUser user = new RegisterUser();;
        webTables.verifyAddedData(user);
    }

    @Then("Verify delete a record")
    public void verifyDeleteRecord (){
        WebTables webTables = new WebTables(BaseClass.getDriver());
        webTables.verifyDeleteRecord();
    }
}
