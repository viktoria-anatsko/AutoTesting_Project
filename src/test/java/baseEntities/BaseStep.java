package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;

    protected AuthorizationPage authorizationPage;
    protected InventoryPage inventoryPage;

    protected ShoppingCartContainerPage shoppingCartContainerPage;
    protected CartPage cartPage;
    protected CheckoutOnePage checkoutOnePage;
    protected CheckoutTwoPage checkoutTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        authorizationPage = new AuthorizationPage(driver);
        inventoryPage = new InventoryPage(driver);
        shoppingCartContainerPage = new ShoppingCartContainerPage(driver);
        cartPage = new CartPage(driver);
        checkoutOnePage = new CheckoutOnePage(driver);
        checkoutTwoPage = new CheckoutTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }
}
