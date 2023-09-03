package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;

public class E2EShoppingTest extends BaseTest {

    @Test
    public void successShoppingTest() {
                authorizationStep.successAuthorization(
                        ReadProperties.username(), ReadProperties.password()
                );

        shoppingStep.successShopping();
        shoppingStep.cartCheckout();
        shoppingStep.purchaseConfirmation();
        shoppingStep.successCartInformation();
        shoppingStep.successFinishShopping().isPageOpened();
    }
}
