package com.ultimateqa.definitions;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static WebDriver getDriver() {
        return driver.get();
    }
}
