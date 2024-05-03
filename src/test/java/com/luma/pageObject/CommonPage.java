package com.luma.pageObject;

import com.luma.utils.LibWebGeneric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//img[@alt='Loading...']")
    WebElement imgLoading;

    public void waitForLoadingIconToDisappear() {
        LibWebGeneric libWebGeneric = new LibWebGeneric();
        libWebGeneric.waitForLoadingIconToDisappear(driver,imgLoading);
    }
}
