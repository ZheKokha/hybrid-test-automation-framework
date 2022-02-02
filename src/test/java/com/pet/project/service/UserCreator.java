package com.pet.project.service;

import com.pet.project.model.User;

public class UserCreator {

    protected static final String USER_NAME = "AutoTestUser9";
    protected static final String PASSWORD = "Te13579@";

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
