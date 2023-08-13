package pages;

import factory.BrowserSingleton;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import services.WaitService;

public class LoginPage {
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");

    private WaitService waitService;

    public LoginPage() {
        waitService = new WaitService();
    }

    public WebElement getEmailInput() {
        return waitService.waitForExists(emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitService.waitForExists(pswInputLocator);
    }

    public boolean isPswInputDisplayed() {
        return waitService.waitForVisibility(getPswInput()).isDisplayed();
    }

    public WebElement getLogInButton() {
        return BrowserSingleton.getInstance().driver.findElement(logInButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public WebElement getErrorTextElement() {
        return BrowserSingleton.getInstance().driver.findElement(errorTextLocator);
    }

    public WebElement getErrorFieldTextElement() {
        return BrowserSingleton.getInstance().driver.findElement(errorFieldTextLocator);
    }

    public void login(User user) {
        setEmail(user.getEmail());
        getPswInput().sendKeys(user.getPassword());
        getLogInButton().click();
    }
}
