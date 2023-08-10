package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOnePage extends InventoryPage {
    private final static String pagePath = "/checkout-step-one.html";

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (id = "first-name")
    public WebElement firstNameInput;

    @FindBy (id = "last-name")
    public WebElement lastNameInput;

    @FindBy (id = "postal-code")
    public WebElement zipCodeInput;

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("continue");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void addCartInformation() {
        firstNameInput.sendKeys("Duke");
        lastNameInput.sendKeys("Poul");
        zipCodeInput.sendKeys("453");
        continueButton.click();
    }
}
