package com.parabanknew.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Data {
    private static Properties data = new Properties();

    static {
        try (InputStream input = new FileInputStream("input/parabanknew/data.properties")) {
            // load a properties file
            data.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return data.getProperty(key);
    }
}
