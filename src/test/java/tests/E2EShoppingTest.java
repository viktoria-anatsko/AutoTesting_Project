package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;

public class E2EShoppingTest extends BaseTest {

    @Test
    public void successShoppingTest() {
                authorizationStep.successAuthorization(
                        ReadProperties.username(), ReadProperties.password()
                ).isPageOpened();

        shoppingStep.successShopping()
                .shoppingCartContainerPage.isPageOpened();
        shoppingStep.cartCheckout().isPageOpened();
        shoppingStep.purchaseConfirmation().isPageOpened();
        shoppingStep.successCartInformation().isPageOpened();
        shoppingStep.successFinishShopping().isPageOpened();
    }
}
