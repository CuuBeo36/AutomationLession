package com.parabanknew.utils;

import org.checkerframework.checker.units.qual.C;

public class Config extends com.automation.core.utils.Config {
    public Config(String filePath) {
        super(filePath);
    }
    public Config() {
        super("input/parabanknew/config.properties");
    }

}
