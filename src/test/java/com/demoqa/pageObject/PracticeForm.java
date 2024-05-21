package com.demoqa.pageObject;

import com.demoqa.pojo.RegisterUser;
import com.demoqa.utils.Env;
import com.demoqa.utils.LibWebGeneric;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PracticeForm {
    WebDriver driver;
    LibWebGeneric libWebGeneric;
    static Logger log = LogManager.getLogger(PracticeForm.class.getName());

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        libWebGeneric = new LibWebGeneric();
    }

    @FindBy(id = "firstName")
    WebElement txtFristName;
    @FindBy(id = "lastName")
    WebElement txtLastName;
    @FindBy(id = "userEmail")
    WebElement txtEmail;
    @FindBy(css = "#gender-radio-1")
    WebElement rdoGender1;
    @FindBy(id = "gender-radio-2")
    WebElement rdoGender2;
    @FindBy(id = "gender-radio-3")
    WebElement rdoGender3;
    @FindBy(id = "userNumber")
    WebElement txtMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement txtDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement txtSubject;
    @FindBy(id = "hobbies-checkbox-1")
    WebElement chkHobby1;
    @FindBy(id = "hobbies-checkbox-2")
    WebElement chkHobby2;
    @FindBy(id = "hobbies-checkbox-3")
    WebElement chkHobby3;
    @FindBy(id = "uploadPicture")
    WebElement fleUploadPicture;
    @FindBy(id = "currentAddress")
    WebElement txaCurrentAddress;
    @FindBy(xpath = "//*[@id='state']")
    WebElement ddlState;
    @FindBy(xpath = "//*[@id='state']/option")
    List<WebElement> lstStates;
    @FindBy(xpath = "//*[@id='city']")
    WebElement ddlCity;
    @FindBy(xpath = "//*[@id='city']/option")
    List<WebElement> lstCity;
    @FindBy(id = "submit")
    WebElement btnSubmit;
    @FindBy(xpath = "//*[@id=\"example-modal-sizes-title-lg\"]")
    WebElement txtMessage;

    public void selectRandomGender() {
        List genderList = Arrays.asList(rdoGender1, rdoGender2, rdoGender3);
        log.info("Start select gender");
        Random rand = new Random();
        WebElement selectedGender = (WebElement) genderList.get(rand.nextInt(genderList.size()));
        Actions actions = new Actions(driver);
        actions.click(selectedGender).perform();
        log.info("End select gender");
    }

    public void selectRandomHobbies() {
        List hobbies = Arrays.asList(chkHobby1, chkHobby2, chkHobby3);
        log.info("Start select hobbies");
        Random rand = new Random();
        WebElement selectedHobby1 = (WebElement) hobbies.get(rand.nextInt(hobbies.size()));
        WebElement selectedHobby2 = (WebElement) hobbies.get(rand.nextInt(hobbies.size()));
        WebElement selectedHobby3 = (WebElement) hobbies.get(rand.nextInt(hobbies.size()));
        List selectedHobbies = Arrays.asList(selectedHobby1,selectedHobby2,selectedHobby3);
        List listWithoutDuplicates = (List) selectedHobbies.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < listWithoutDuplicates.size(); i++) {
            Actions actions = new Actions(driver);
            actions.click((WebElement) listWithoutDuplicates.get(i)).perform();
        }
    }

    public void selectRandomState(){
        log.info("Start to select State");
        libWebGeneric.scrollToElement(driver, ddlState);
        ddlState.click();
        int maxStates = lstStates.size();
        log.info("Max states = " + maxStates);
        Random random = new Random();
        int randomState = random.nextInt(maxStates);
        log.info("random State" + randomState);
        // Select the list item
        lstStates.get(randomState).click();
        log.info("End select State");
    }

    public void selectRandomCity(){
        log.info("Start to select City");
        libWebGeneric.scrollToElement(driver, ddlCity);
        ddlCity.click();
        int maxCities = lstCity.size();
        Random random = new Random();
        int randomCity = random.nextInt(maxCities);
        log.info("random City" + randomCity);
        // Select the list item
        lstStates.get(randomCity).click();
        log.info("End select City");
    }
    //    public void pickerDate(){
//        List<WebElement> datePickerDays = driver.findElements(By.id("dateOfBirthInput"));
//        datePickerDays.stream().filter(e->e.getText().equals(today)).findFirst().get().click();
//}
    public void uploadPicture(){
        String file_path = System.getProperty("user.dir") + Env.getProperty("uploadPicture");
        log.info("File path: " + file_path);
        fleUploadPicture.sendKeys(file_path);
    }

    public void register (RegisterUser user){
        txtFristName.sendKeys(user.getFirstName());
        txtLastName.sendKeys(user.getLastName());
        txtEmail.sendKeys(user.getEmail());

        selectRandomGender();

        txtMobile.sendKeys(user.getMobile());
//        txtDateOfBirth.sendKeys(user.getDateOfBirth());

        libWebGeneric.waitElementVisible(driver,txtSubject);
        txtSubject.sendKeys(user.getSubject());

        selectRandomHobbies();

        uploadPicture();

        libWebGeneric.waitElementVisible(driver, txaCurrentAddress);
        libWebGeneric.scrollToElement(driver, txaCurrentAddress);
        txaCurrentAddress.sendKeys(user.getCurrentAddress());

        libWebGeneric.waitElementVisible(driver, ddlState);
        selectRandomState();
        libWebGeneric.waitElementVisible(driver, ddlCity);
        selectRandomCity();

        btnSubmit.click();
    }
    public void verifyRegisterMessage(String expectedMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtMessage));
        String actualMessage = txtMessage.getText();
        log.info("Actual Message " + actualMessage);
        log.info("Expected Message " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
