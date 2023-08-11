package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    private final static String pagePath = "/inventory.html";

    private final By headerTitleLabelLocator = By.cssSelector(".title");

    private final By buttonAddToCart_1 = By.id("add-to-cart-sauce-labs-backpack");

    private final By shoppingCartContainerLocator = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getHeaderTitle() {
        return driver.findElement((headerTitleLabelLocator));
    }

    public WebElement getButtonAddToCart_1() {
        return driver.findElement(buttonAddToCart_1);
    }

    public WebElement getShoppingCartContainerLocator() {
        return driver.findElement(shoppingCartContainerLocator);
    }

    public InventoryPage addToCart() {
        getButtonAddToCart_1().click();
        return this;
    }

    public CartPage clickToShoppingCart() {
        getShoppingCartContainerLocator().click();
        return new CartPage(driver);
    }
}
