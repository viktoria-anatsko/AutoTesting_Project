package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartContainerPage extends BasePage {
    private final By shoppingCartContainerLocator = By.id("shopping_cart_container");
    private final By shoppingCartBadgeLocator = By.className("shopping_cart_badge");

    public ShoppingCartContainerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return shoppingCartContainerLocator;
    }

    public WebElement getShoppingCartContainerElement() {
        return driver.findElement(shoppingCartContainerLocator);
    }

    public WebElement getShoppingCartBadgeElement() {
        return driver.findElement(shoppingCartBadgeLocator);
    }

    public void clickToShoppingCartLink() {
        getShoppingCartBadgeElement().click();
    }
}
