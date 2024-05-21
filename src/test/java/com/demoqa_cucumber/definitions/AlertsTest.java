package com.demoqa_cucumber.definitions;

import com.demoqa_cucumber.pageObject.Alerts;
import com.demoqa_cucumber.runner.CucumberRunnerTests;
import com.demoqa_cucumber.utils.Env;
import com.demoqa_cucumber.utils.Text;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AlertsTest {
    static Logger log = LogManager.getLogger(AlertsTest.class.getName());
    @When("User go to Alert page")
    public void openAlertPage(){
        BaseClass.getDriver().get(Env.getProperty("alertsUrl"));
    }

    @Then("Verify normal alert is displayed")
    public void verifyNormalAlert() throws InterruptedException {
        Alerts alerts = new Alerts(BaseClass.getDriver());
        String expectedAlert = Text.getProperty("expectedAlert");
        alerts.verifyAlert(expectedAlert);
    }
    @Then("Verify Timer alert is displayed")
    public void verifyTimerAlert() throws InterruptedException {
        Alerts alerts = new Alerts(BaseClass.getDriver());
        String expectedAlert = Text.getProperty("expectedTimerAlert");
        alerts.verifyTimerAlert(expectedAlert);
    }

    @Then("Verify Confirm alert OK")
    public void verifyConfirmAlertOK() throws InterruptedException {
        Alerts alerts = new Alerts(BaseClass.getDriver());
        String expectedAlert = Text.getProperty("expectedConfirmAlertOK");
        alerts.confirmAlertOk(expectedAlert);
    }

    @Then("Verify Prompt Box")
    public void verifyPromptBox() throws InterruptedException {
        Alerts alerts = new Alerts(BaseClass.getDriver());
        alerts.verifyPromtBox();
    }
}
