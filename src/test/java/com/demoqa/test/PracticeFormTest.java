package com.demoqa.test;


import com.demoqa.pageObject.PracticeForm;
import com.demoqa.pojo.RegisterUser;
import com.demoqa.utils.Env;
import com.luma.utils.Message;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PracticeFormTest extends BaseClass{
    static Logger log = Logger.getLogger(PracticeFormTest.class.getName());

    @Test (description = "TestRegisterSuccess")
    public void testRegisterFull() throws InterruptedException {
        getDriver().get(Env.getProperty("practiceUrl"));
        PracticeForm practiceForm = new PracticeForm(getDriver());

        RegisterUser user = new RegisterUser();
        user.generateRegisterUser();
        practiceForm.register(user);

        String expectedMessage = Message.getProperty("registerSuccessMessage");
        practiceForm.verifyRegisterMessage(expectedMessage);
    }
}
