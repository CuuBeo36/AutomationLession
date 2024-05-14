package com.demoqa.test;

import com.demoqa.pageObject.Alerts;
import com.demoqa.pageObject.ModalDialog;
import com.demoqa.utils.Env;
import com.demoqa.utils.Text;
import com.demoqa.utils.Text;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AlertsTest extends BaseClass{
    static Logger log = LogManager.getLogger(AlertsTest.class.getName());
    @Test(priority = 0, description = "Normal Alert")
    public void TestNormalAlert() throws InterruptedException {
        getDriver().get(Env.getProperty("alertsUrl"));
        Alerts alerts = new Alerts(getDriver());

        String expectedAlert = Text.getProperty("expectedAlert");
        alerts.verifyAlert(expectedAlert);
    }
    @Test(priority = 1, description = "Timer Alert")
    public void TestTimerAlert() throws InterruptedException {
        getDriver().get(Env.getProperty("alertsUrl"));
        Alerts alerts = new Alerts(getDriver());

        String expectedAlert = Text.getProperty("expectedTimerAlert");
        alerts.verifyTimerAlert(expectedAlert);
    }
    @Test(priority = 2, description = "Confrim Alert OK")
    public void TestConfirmAlertOK() throws InterruptedException {
        getDriver().get(Env.getProperty("alertsUrl"));
        Alerts alerts = new Alerts(getDriver());

        String expectedAlert = Text.getProperty("expectedConfirmAlertOK");
        alerts.confirmAlertOk(expectedAlert);
    }

    @Test(priority = 3, description = "Prompt Box")
    public void TestPromptBox() throws InterruptedException {
        getDriver().get(Env.getProperty("alertsUrl"));
        Alerts alerts = new Alerts(getDriver());

        alerts.verifyPromtBox();
    }
}
