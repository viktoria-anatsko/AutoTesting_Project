package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutTwoPage extends InventoryPage {
    private final static String pagePath = "/checkout-step-two.html";

    private final By finishButtonLocator = By.id("finish");

    public CheckoutTwoPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getFinishButton() {
        return $(finishButtonLocator);
    }

    public void finishShopping() {
        getFinishButton().click();
    }
}
