package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOnePage extends InventoryPage {
    private final static String pagePath = "/checkout-step-one.html";

    private final By continueButtonLocator = By.id("continue");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInputLocator);
    }

    public void addCartInformation() {
        getFirstNameInput().sendKeys("Duke");
        getLastNameInput().sendKeys("Poul");
        getZipCodeInput().sendKeys("453");
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
}
