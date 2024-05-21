package com.demoqa_cucumber.pageObject;

import com.demoqa_cucumber.pojo.RegisterUser;
import com.demoqa_cucumber.utils.LibWebGeneric;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class WebTables {
    WebDriver driver;
    LibWebGeneric libWebGeneric;
    static Logger log = LogManager.getLogger(WebTables.class.getName());
    public WebTables(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        libWebGeneric = new LibWebGeneric();
    }
    @FindBy (css = "#addNewRecordButton")
    WebElement btnAdd;
    @FindBy (id = "firstName")
    WebElement txtFirstName;
    @FindBy (id = "lastName")
    WebElement txtLastName;
    @FindBy (id = "userEmail")
    WebElement txtEmail;
    @FindBy (id = "age")
    WebElement txtAge;
    @FindBy (id = "salary")
    WebElement txtSalary;
    @FindBy (id = "department")
    WebElement txtDepartment;
    @FindBy (id = "submit")
    WebElement btnSubmit;
    @FindBy (id = "delete-record-1")
    WebElement btnDeleteRecord1;
    @FindBy (xpath = "")
    WebElement lblFirstRow;//*[@class='rt-tr -odd'][div[1][@class='rt-td'][text()='Cierra']][div[2][@class='rt-td'][text()='Vega']][div[3][@class='rt-td'][text()='39']][div[4][@class='rt-td'][text()='cierra@example.com']][div[5][@class='rt-td'][text()='10000']][div[6][@class='rt-td'][text()='Insurance']]

    @FindBy (xpath = "//*[@class='rt-tr -odd'][div[1][@class='rt-td'][text()='firstName']][div[2][@class='rt-td'][text()='lastName']][div[3][@class='rt-td'][text()='age']]")
    WebElement lblLastRow;

    public void registration(RegisterUser user){
        btnAdd.click();
        txtFirstName.sendKeys(user.getFirstName());
        txtLastName.sendKeys(user.getLastName());
        txtEmail.sendKeys(user.getEmail());
        txtAge.sendKeys(user.getAge());
        txtSalary.sendKeys(user.getSalary());
        txtDepartment.sendKeys(user.getDepartment());
        btnSubmit.click();
    }

    public void verifyAddedData(RegisterUser user){
        String actualLastRow = "//*[@class='rt-tr -odd'][div[1][@class='rt-td'][text()='"+ user.getFirstName()+"']][div[2][@class='rt-td'][text()='"+user.getLastName()+"']][div[3][@class='rt-td'][text()='"+user.getAge()+"']]";
        Assert.assertTrue(driver.findElement(By.xpath(actualLastRow)).isDisplayed());
        log.info("Last row: " + actualLastRow);
    }

    public void verifyDeleteRecord(){
//        lblFirstRow.isDisplayed();
        btnDeleteRecord1.click();
        Assert.assertFalse(lblFirstRow.isDisplayed());
    }
}
