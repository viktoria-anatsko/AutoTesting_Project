package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy (id = "user-name")
    public WebElement userNameInput;

    @FindBy (id = "password")
    public WebElement pswInput;

    @FindBy (id = "login-button")
    public WebElement loginButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("login-button");
    }

    public void authorization(String username, String psw) {
        userNameInput.sendKeys(username);
        pswInput.sendKeys(psw);
        loginButton.click();
    }
}
