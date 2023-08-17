package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartContainerPage extends BasePage {
    private final By shoppingCartContainerLocator = By.id("shopping_cart_container");
    private final By shoppingCartBadgeLocator = By.className("shopping_cart_badge");

    public ShoppingCartContainerPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return shoppingCartContainerLocator;
    }

    public SelenideElement getShoppingCartContainerElement() {
        return $(shoppingCartContainerLocator);
    }

    public SelenideElement getShoppingCartBadgeElement() {
        return $(shoppingCartBadgeLocator);
    }

    public void clickToShoppingCartLink() {
        getShoppingCartBadgeElement().click();
    }
}
