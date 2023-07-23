package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;


public class E2EShoppingTest extends BaseTest {

    @Test
    public void successShoppingTest() {
        Assert.assertTrue(
                authorizationStep.successAuthorization(
                        ReadProperties.username(), ReadProperties.password()
                ).isPageOpened());

        Assert.assertEquals(shoppingStep.successShopping()
                .shoppingCartContainerPage.getShoppingCartBadgeElement().getText(), "1");
        Assert.assertTrue(shoppingStep.cartCheckout().isPageOpened());
        Assert.assertTrue(shoppingStep.purchaseConfirmation().isPageOpened());
        Assert.assertTrue(shoppingStep.successCartInformation().isPageOpened());
        Assert.assertTrue(shoppingStep.successFinishShopping().isPageOpened());
    }
}
