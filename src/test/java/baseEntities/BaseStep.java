package baseEntities;

import pages.*;

public class BaseStep {
    protected AuthorizationPage authorizationPage;
    protected InventoryPage inventoryPage;

    protected ShoppingCartContainerPage shoppingCartContainerPage;
    protected CartPage cartPage;
    protected CheckoutOnePage checkoutOnePage;
    protected CheckoutTwoPage checkoutTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;

    public BaseStep() {
        authorizationPage = new AuthorizationPage();
        inventoryPage = new InventoryPage();
        shoppingCartContainerPage = new ShoppingCartContainerPage();
        cartPage = new CartPage();
        checkoutOnePage = new CheckoutOnePage();
        checkoutTwoPage = new CheckoutTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }
}
