package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutTwoPage extends InventoryPage {
    private final static String pagePath = "/checkout-step-two.html";

    private final By finishButtonLocator = By.id("finish");

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

    public CheckoutCompletePage finishShopping() {
        getFinishButton().click();
        return new CheckoutCompletePage(driver);
    }
}
