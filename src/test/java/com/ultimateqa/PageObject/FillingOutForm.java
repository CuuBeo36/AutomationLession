package com.ultimateqa.PageObject;
import com.ultimateqa.pojo.From;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FillingOutForm {
    WebDriver driver;
    static Logger log = LogManager.getLogger(FillingOutForm.class.getName());

    public FillingOutForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "et_pb_contact_name_0")
    WebElement txtName0;
    @FindBy (id = "et_pb_contact_message_0")
    WebElement txtMessage0;
    @FindBy (xpath = "//*[@id='et_pb_contact_form_0']//button")
    WebElement btnSubmit0;
    @FindBy (css = "#et_pb_contact_form_0")
    WebElement txtConfirmMessage0;
    @FindBy (id = "et_pb_contact_name_1")
    WebElement txtName1;
    @FindBy (id = "et_pb_contact_message_1")
    WebElement txtMessage1;
    @FindBy (xpath = "//*[@class='et_pb_contact_captcha_question']")
    WebElement txtQuestion;
    @FindBy (xpath = "//*[@id='et_pb_contact_form_1']//button")
    WebElement btnSubmit1;
    @FindBy (xpath = "//*[@id='et_pb_contact_form_1']/div[2]/form/div/div/p/input")
    WebElement txtSubmit;
    @FindBy (css = "#et_pb_contact_form_1")
    WebElement txtConfirmMessage1;

    public void generateForm0(From form){
        txtName0.sendKeys(form.getName0());
        txtMessage0.sendKeys(form.getMessage0());
        btnSubmit0.click();

    }
    public void verifyForm0() throws InterruptedException {
        Thread.sleep(3000);
        String confirmMessage0 = txtConfirmMessage0.getText();
        log.info("Actual Message: " + confirmMessage0);
        Assert.assertEquals(confirmMessage0, "Thanks for contacting us");
    }

    public void generateForm1(From form){
        txtName1.sendKeys(form.getName1());
        txtMessage1.sendKeys(form.getMessage1());
        String question = txtQuestion.getText();
        log.info("Question: " + question );
        String sub1 = StringUtils.substringBefore(question, "+");
        int number1 = Integer.valueOf(sub1.replaceAll("\\s",""));
        log.info("Number 1 : " + number1 );
        String sub2 = StringUtils.substringAfter(question, "+");
        int number2 = Integer.valueOf(sub2.replaceAll("\\s",""));
        log.info("Number 2 : " + number2 );
        int sum = number1 + number2;
        log.info("Sum of 2 : " + sum );
        txtSubmit.sendKeys(String.valueOf(sum));
        btnSubmit1.click();
    }

    public void verifyForm1() throws InterruptedException {
        Thread.sleep(3000);
        String confirmMessage0 = txtConfirmMessage1.getText();
        log.info("Actual Message: " + confirmMessage0);
        Assert.assertEquals(confirmMessage0, "Thanks for contacting us");
    }
}
