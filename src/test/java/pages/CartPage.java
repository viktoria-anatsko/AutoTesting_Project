package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends InventoryPage {
    private final static String pagePath = "/cart.html";

    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("checkout");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void confirmPurchase() {
        checkoutButton.click();
    }
}
