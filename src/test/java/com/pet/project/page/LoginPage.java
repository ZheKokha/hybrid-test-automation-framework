package com.pet.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{

    private final String PAGE_URL = "https://github.com/login";

    @FindBy(id = "login_field")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSubmit;

    @Override
    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return new MainPage(driver);
    }
}
