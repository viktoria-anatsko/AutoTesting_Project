package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends InventoryPage {
    private final static String pagePath = "/cart.html";

    private final By checkoutButtonLocator = By.id("checkout");

    public CartPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getCheckoutButton() {
        return $(checkoutButtonLocator);
    }

    public void confirmPurchase() {
        getCheckoutButton().click();
    }
}
