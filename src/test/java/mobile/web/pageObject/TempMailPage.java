package mobile.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TempMailPage {
    WebDriver driver;
    public TempMailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
}
    @FindBy (id= "mail")
    WebElement txtEmail;

     public String getEmail() throws InterruptedException {
         Thread.sleep(5000);
         String email = txtEmail.getAttribute("value");
         System.out.println("email: " + email);
         return email;
     }
}
