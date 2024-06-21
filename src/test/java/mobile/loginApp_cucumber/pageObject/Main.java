package mobile.loginApp_cucumber.pageObject;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\input\\mobile\\devices.json")));
            JSONObject devices = new JSONObject(content);
            JSONObject device5 = devices.getJSONObject("Device5");

            // Create DesiredCapabilities object
            DesiredCapabilities caps = new DesiredCapabilities();

            // Use entrySet().iterator() to iterate over the device5
            Iterator<Map.Entry<String, Object>> it = device5.toMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> pair = it.next();
                if (pair.getKey().equals("bstack:options")) {
                    Object value = pair.getValue();
                    JSONObject bstackOptions;
                    if (value instanceof JSONObject) {
                        bstackOptions = (JSONObject) value;
                    } else if (value instanceof HashMap) {
                        bstackOptions = new JSONObject((HashMap) value);
                    } else {
                        throw new IllegalArgumentException("Value is not a JSONObject or HashMap");
                    }
                    HashMap<String, Object> bstackMap = new HashMap<>(bstackOptions.toMap());
                    caps.setCapability(pair.getKey(), bstackMap);
                } else {
                    caps.setCapability(pair.getKey(), pair.getValue());
                }
            }

            // Now you can use the capabilities with BrowserStack
            WebDriver driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);

            // Your test code goes here

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}