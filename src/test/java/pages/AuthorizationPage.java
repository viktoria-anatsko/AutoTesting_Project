package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BasePage {
    private final By userNameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.className("error-message-container error");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    public WebElement getUserNameInput() {
        return driver.findElement(userNameInputLocator);
    }

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }

    public void authorization(String username, String psw) {
        getUserNameInput().sendKeys(username);
        getPswInput().sendKeys(psw);
        getLoginButton().click();
    }
}
