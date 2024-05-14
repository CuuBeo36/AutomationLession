package com.demoqa.test;

import com.demoqa.pageObject.ModalDialog;
import com.demoqa.pageObject.PracticeForm;
import com.demoqa.pojo.RegisterUser;
import com.demoqa.utils.Env;
import com.demoqa.utils.Text;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class ModalDialogTest extends BaseClass{
    static Logger log = Logger.getLogger(ModalDialogTest.class.getName());

    @Test (priority = 0, description = "SmallDialog")
    public void testSmallDialog() throws InterruptedException {
        getDriver().get(Env.getProperty("modalDialogUrl"));
        ModalDialog modalDialog= new ModalDialog(getDriver());

        String expectedSmallTitle = Text.getProperty("expectedSmallTitle");
        log.info("Expected Small Title: " + expectedSmallTitle);
        modalDialog.verifySmallModal(expectedSmallTitle);
    }

    @Test (priority = 1, description = "LargeDialog")
    public void TestLargeDialog() throws InterruptedException {
        getDriver().get(Env.getProperty("modalDialogUrl"));
        ModalDialog modalDialog= new ModalDialog(getDriver());

        String expectedLargeTitle = Text.getProperty("expectedLargeTitle");
        log.info("Expected Large Title: " + expectedLargeTitle);
        modalDialog.verifyLargeModal(expectedLargeTitle);

    }
}
