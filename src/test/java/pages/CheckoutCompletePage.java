package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends InventoryPage {
    private final static String pagePath = "/checkout-complete.html";

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("back-to-products");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
