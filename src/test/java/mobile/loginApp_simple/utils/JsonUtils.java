package mobile.loginApp_simple.utils;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class JsonUtils {
    public static DesiredCapabilities getCapabilitiesFromJson(String deviceName) {
        String jsonFilePath = "input/mobile/devices.json"; // Replace with your actual JSON file path
        FileInputStream jsonFile;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            jsonFile = new FileInputStream(jsonFilePath);
            JSONObject jsonObject = new JSONObject(new JSONTokener(jsonFile));
            JSONObject deviceCapabilities = jsonObject.getJSONObject(deviceName);

            Iterator<String> keys = deviceCapabilities.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = deviceCapabilities.getString(key);
                capabilities.setCapability(key, value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return capabilities;
    }
}
