package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends InventoryPage {
    private final static String pagePath = "/checkout-complete.html";

    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getBackHomeButtonLocator() {
        return driver.findElement(backHomeButtonLocator);
    }
}
