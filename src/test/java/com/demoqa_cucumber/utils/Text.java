package com.demoqa_cucumber.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Text {
    private static Properties prop = new Properties();

    static {
        try (InputStream input = new FileInputStream("input/demoqa/text.properties")) {
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
