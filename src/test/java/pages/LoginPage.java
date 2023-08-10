package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy (id = "password")
    public WebElement pswInput;

    @FindBy (id = "button_primary")
    public WebElement logInButton;

    @FindBy (className = "error-text")
    public WebElement errorText;

    @FindBy (className = "loginpage-message")
    public WebElement errorFieldText;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("button_primary");
    }

    public void login(String username, String psw) {
        emailInput.sendKeys(username);
        pswInput.sendKeys(psw);
        logInButton.click();
    }
}
