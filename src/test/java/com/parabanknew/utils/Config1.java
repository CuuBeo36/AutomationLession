package com.parabanknew.utils;

import com.automation.core.utils.Config;


public class Config1 {
    public static String getProperty(String key) {
        return new Config("input/parabanknew/config.properties").getProperty(key);
    }
}
