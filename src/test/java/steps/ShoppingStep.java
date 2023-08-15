package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ShoppingStep extends BaseStep {
    Logger logger = LogManager.getLogger(ShoppingStep.class);

    public ShoppingStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successShopping() {
        inventoryPage.addToCart();

        logger.info("Product is added");
        return inventoryPage;
    }

    public CartPage cartCheckout() {
        shoppingCartContainerPage.clickToShoppingCartLink();

        logger.info("Shopping Cart is opened");
        return cartPage;
    }

    public CheckoutOnePage purchaseConfirmation() {
        cartPage.confirmPurchase();

        logger.info("Checkout Page is opened");
        return checkoutOnePage;
    }

    public CheckoutTwoPage successCartInformation() {
        checkoutOnePage.addCartInformation();

        logger.info("Cart Information is added successfully");
        return checkoutTwoPage;
    }

    public CheckoutCompletePage successFinishShopping() {
        checkoutTwoPage.finishShopping();

        logger.info("Purchase process is completed");
        return  checkoutCompletePage;
    }
}
