package com.pet.project.ui.test;

import com.pet.project.ui.model.User;
import com.pet.project.ui.page.LoginPage;
import com.pet.project.ui.service.UserCreator;
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
