package com.pet.project.test;

import com.pet.project.page.LoginPage;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class RepositoryManagementTests extends CommonConditions{

    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    @Test(description = "create new repository")
    public void oneCanCreateProject()
    {
        String expectedRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(USER_NAME, PASSWORD)
                .invokeNewRepositoryCreation()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();

        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @Test(description = "check if repository is empty")
    public void newProjectsAreEmpty()
    {
        String testRepositoryName = generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(USER_NAME, PASSWORD)
                .invokeNewRepositoryCreation()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }

    private String getRandomString(int stringLength)
    {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++)
        {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    private String generateRandomRepositoryNameWithPostfixLength(int postfixLength){
        return "testRepo_".concat(getRandomString(postfixLength));
    }
}
