package com.pet.project.ui.service;

import java.util.ResourceBundle;

public class PropertiesReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
