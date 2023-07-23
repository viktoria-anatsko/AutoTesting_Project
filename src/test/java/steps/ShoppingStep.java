package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ShoppingStep extends BaseStep {

    public ShoppingStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successShopping() {
        inventoryPage.addToCart();

        return inventoryPage;
    }

    public CartPage cartCheckout() {
        shoppingCartContainerPage.clickToShoppingCartLink();

        return cartPage;
    }

    public CheckoutOnePage purchaseConfirmation() {
        cartPage.confirmPurchase();

        return checkoutOnePage;
    }

    public CheckoutTwoPage successCartInformation() {
        checkoutOnePage.addCartInformation();

        return checkoutTwoPage;
    }

    public CheckoutCompletePage successFinishShopping() {
        checkoutTwoPage.finishShopping();

        return  checkoutCompletePage;
    }
}
