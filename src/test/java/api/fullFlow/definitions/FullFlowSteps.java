package api.fullFlow.definitions;

import api.fullFlow.pageObject.LoginPage;
import api.fullFlow.pojo.User;
import com.automation.core.utils.BStackJson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FullFlowSteps {
    private static final String BASE_URL = "https://reqres.in/api/users/2";
    private Response response;
    RemoteWebDriver remoteWebDriver;

    @Given("Set up the API URL")
    public void theRestAPIIsUpAndRunning() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("Send GET request to the API to get email")
    public void iSendAGETRequestToTheAPI() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get();

        JSONObject jsonObject = new JSONObject(response);
        String email1 = jsonObject.getJSONObject("data").getString("email");
        System.out.println("Email: " + email1);
    }
    @Then ("Login App mobileWeb by email from API")
    public void setupMobileWebFromJson() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities = BStackJson.getCapabilitiesFromJson("Device5");

        remoteWebDriver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);

//        LoginPage loginPage = new LoginPage(remoteWebDriver);
//        User user = new User();
//        user.generateLoginUser();
//        user.setEmail(email1);
//        loginPage.login(user);
//        loginPage.verifyLoginFail();
    }
}
