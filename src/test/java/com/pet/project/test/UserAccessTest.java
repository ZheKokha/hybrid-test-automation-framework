package com.pet.project.test;

import com.pet.project.page.LoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTest extends CommonConditions{

    @Test
    public void oneCanLoginGithub()
    {
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(USER_NAME, PASSWORD)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(USER_NAME)));
    }
}
