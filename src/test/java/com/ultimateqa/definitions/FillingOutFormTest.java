package com.ultimateqa.definitions;

import com.demoqa_cucumber.utils.Env;
import com.ultimateqa.PageObject.FillingOutForm;
import com.ultimateqa.pojo.From;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FillingOutFormTest extends BaseClass{
    static Logger log = LogManager.getLogger(FillingOutFormTest.class.getName());

    String baseUrl = "https://ultimateqa.com/filling-out-forms/";
    long implicitlyWait;
    @Given ("User go to FillingOutForm Page")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
//        options.addArguments("--headless");
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
        implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }
    @When("User submit form 0")
    public void sumbitForm0(){
        FillingOutForm fillingOutForm = new FillingOutForm(getDriver());
        From form0 = new From();
        form0.generateForm0();
        fillingOutForm.generateForm0(form0);
    }

    @Then("Verify form 0 is submitted successfully")
    public void verifyForm0() throws InterruptedException {
        FillingOutForm fillingOutForm = new FillingOutForm(getDriver());
        fillingOutForm.verifyForm0();
    }

    @When("User submit form 1")
    public void submitForm1(){
        FillingOutForm fillingOutForm = new FillingOutForm(getDriver());
        From form1 = new From();
        form1.generateForm1();
        fillingOutForm.generateForm1(form1);
    }

    @Then("Verify form 1 is submitted successfully")
    public void verifyForm1() throws InterruptedException {
        FillingOutForm fillingOutForm = new FillingOutForm(getDriver());
        fillingOutForm.verifyForm1();
    }
    @And("User close a browser")
    public void tearDown(){
        driver.get().quit();
    }
}
