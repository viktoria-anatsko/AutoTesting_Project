package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOnePage extends InventoryPage {
    private final static String pagePath = "/checkout-step-one.html";

    private final By continueButtonLocator = By.id("continue");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");

    public CheckoutOnePage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator);
    }

    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator);
    }

    public SelenideElement getZipCodeInput() {
        return $(zipCodeInputLocator);
    }

    public void addCartInformation() {
        getFirstNameInput().setValue("Duke");
        getLastNameInput().setValue("Poul");
        getZipCodeInput().setValue("453");
        getContinueButton().click();
    }
}
