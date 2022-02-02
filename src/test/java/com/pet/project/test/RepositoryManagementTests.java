package com.pet.project.test;

import com.pet.project.model.User;
import com.pet.project.page.LoginPage;
import com.pet.project.service.UserCreator;
import org.testng.annotations.Test;

import java.util.Random;

import static com.pet.project.utils.StringUtil.generateRandomRepositoryNameWithPostfixLength;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class RepositoryManagementTests extends CommonConditions{

    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";


    @Test(description = "create new repository")
    public void oneCanCreateProject() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .invokeNewRepositoryCreation()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();

        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @Test(description = "check if repository is empty")
    public void newProjectsAreEmpty() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String testRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .invokeNewRepositoryCreation()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }

}
