package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LoginPage extends BasePage {
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public Input getEmailInput() {
        return new Input(driver, emailInputLocator);
    }

    public Input getPswInput() {
        return new Input(driver, pswInputLocator);
    }

    public boolean isPswInputDisplayed() {
        return getPswInput().isDisplayed();
    }

    public Button getLogInButton() {
        return new Button(driver, logInButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }

    public WebElement getErrorFieldTextElement() {
        return driver.findElement(errorFieldTextLocator);
    }

    public void login(String username, String psw) {
        setEmail(username);
        getPswInput().sendKeys(psw);
        getLogInButton().click();
    }
}
