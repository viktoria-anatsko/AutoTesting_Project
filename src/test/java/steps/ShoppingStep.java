package steps;

import baseEntities.BaseStep_;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ShoppingStep extends BaseStep_ {

    public ShoppingStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successShopping() {
        inventoryPage.addToCart();

        return inventoryPage;
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
