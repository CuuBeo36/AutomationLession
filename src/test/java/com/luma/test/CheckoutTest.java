package com.luma.test;

import com.luma.pageObject.CheckoutPage;
import com.luma.pageObject.CommonPage;
import com.luma.pageObject.HomePage;
import com.luma.pojo.CheckoutUser;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseClass {


    static Logger log = Logger.getLogger(com.luma.test.CheckoutTest.class.getName());


    @Test(description = "testCheckoutNoSignIn")
    public void testCheckoutNoSignIn() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.selectWomen();
        homePage.selectWomenTops();
        homePage.clickWomenJackets();
        homePage.clickJacketSize();
        homePage.clickJacketColor();
        homePage.clickAddToCart();
        homePage.verifyAddSuccessMessage();
        homePage.clickShowCart();
        homePage.clickCheckout();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.waitForLoadingIconToDisappear();

        CheckoutUser user = new CheckoutUser();
        user.generateCheckOutUser();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.checkout(user);
    }
    @Test(description = "testCheckoutNoSignIn1")
    public void testCheckoutNoSignIn1() throws InterruptedException {
        getDriver().get("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html");
        HomePage homePage = new HomePage(getDriver());

        homePage.clickJacketSize();
        homePage.clickJacketColor();
        homePage.clickAddToCart();
        homePage.verifyAddSuccessMessage();
        homePage.clickShowCart();
        homePage.clickCheckout();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.waitForLoadingIconToDisappear();

        CheckoutUser user = new CheckoutUser();
        user.generateCheckOutUser();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.checkout(user);

    }

}
