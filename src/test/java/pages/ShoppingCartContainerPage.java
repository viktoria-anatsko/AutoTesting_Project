package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartContainerPage extends BasePage {

    @FindBy (id = "shopping_cart_container")
    public WebElement shoppingCartContainer;

    @FindBy (className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;

    public ShoppingCartContainerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("shopping_cart_container");
    }

    public void clickToShoppingCartLink() {
        shoppingCartBadge.click();
    }
}
