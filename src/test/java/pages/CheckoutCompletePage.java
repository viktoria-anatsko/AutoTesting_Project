package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends InventoryPage {
    private final static String pagePath = "/checkout-complete.html";

    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getBackHomeButtonLocator() {
        return $(backHomeButtonLocator);
    }
}
