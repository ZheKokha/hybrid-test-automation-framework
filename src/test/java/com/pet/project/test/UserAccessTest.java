package com.pet.project.test;

import com.pet.project.model.User;
import com.pet.project.page.LoginPage;
import com.pet.project.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTest extends CommonConditions{

    @Test
    public void oneCanLoginGithub() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
    }
}
