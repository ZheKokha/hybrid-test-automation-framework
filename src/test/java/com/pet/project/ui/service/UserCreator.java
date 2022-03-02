package com.pet.project.ui.service;

import com.pet.project.ui.model.User;

public class UserCreator {

    protected static final String USER_NAME = PropertiesReader.getTestData("testdata.user.name");
    protected static final String PASSWORD = PropertiesReader.getTestData("testdata.user.password");

    public static User withCredentialsFromProperty() {
        return new User(USER_NAME, PASSWORD);
    }

    public static User withEmptyUsername() {
        return new User("", PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_NAME, "");
    }
}
