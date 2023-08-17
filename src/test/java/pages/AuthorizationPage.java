package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends BasePage {
    private final By userNameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    public AuthorizationPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    public SelenideElement getUserNameInput() {
        return $(userNameInputLocator);
    }

    public SelenideElement getPswInput() {
        return $(pswInputLocator);
    }

    public SelenideElement getLoginButton() {
        return $(loginButtonLocator);
    }

    public void authorization(String username, String psw) {
        getUserNameInput().setValue(username);
        getPswInput().setValue(psw);
        getLoginButton().click();
    }
}
