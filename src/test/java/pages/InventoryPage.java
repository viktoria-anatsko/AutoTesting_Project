package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage extends BasePage {
    private final static String pagePath = "/inventory.html";

    private final By headerTitleLabelLocator = By.cssSelector(".title");

    private final By buttonAddToCart_1 = By.id("add-to-cart-sauce-labs-backpack");

    public ShoppingCartContainerPage shoppingCartContainerPage;

    public BurgerMenuPage burgerMenuPage;

    public InventoryPage() {
        super();

        shoppingCartContainerPage = new ShoppingCartContainerPage();
        burgerMenuPage = new BurgerMenuPage();
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getHeaderTitle() {
        return $(headerTitleLabelLocator);
    }

    public SelenideElement getButtonAddToCart_1() {
        return $(buttonAddToCart_1);
    }

    public void addToCart() {
        getButtonAddToCart_1().click();
    }
}
