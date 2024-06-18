package com.anhtester.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageFactory {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signinBtn;


    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // Và khởi tạo initElements
    public SignInPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Chúng ta viết hàm signin không cần dùng các hàm bổ trợ enter hay click nữa
    public void signin(String username, String password, String Pin) throws Exception {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signinBtn.click();
        Thread.sleep(1000);
    }
}
