package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    private final static String pagePath = "/inventory.html";

    @FindBy (css = ".title")
    public WebElement headerTitleLabel;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement buttonAddToCart_1;

    public ShoppingCartContainerPage shoppingCartContainerPage;

    public BurgerMenuPage burgerMenuPage;

    public InventoryPage(WebDriver driver) {
        super(driver);

        shoppingCartContainerPage = new ShoppingCartContainerPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector(".title");
    }

    public void addToCart() {
        buttonAddToCart_1.click();
    }
}
