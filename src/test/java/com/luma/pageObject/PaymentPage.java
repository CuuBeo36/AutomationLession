package com.luma.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
//    @FindBy (xpath = )
//    WebElement btnPayment;
}
