package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;


public class E2EShoppingTest extends BaseTest {

    @Test
    public void successShoppingTest() {
        Assert.assertTrue(
                authorizationStep.successAuthorization(DataHelper.getAdminUser()).isPageOpened());

        Assert.assertEquals(shoppingStep.successShopping()
                .shoppingCartContainerPage.getShoppingCartBadgeElement().getText(), "1");
        Assert.assertTrue(shoppingStep.cartCheckout().isPageOpened());
        Assert.assertTrue(shoppingStep.purchaseConfirmation().isPageOpened());
        Assert.assertTrue(shoppingStep.successCartInformation().isPageOpened());
        Assert.assertTrue(shoppingStep.successFinishShopping().isPageOpened());
    }

    @Test
    public void builderTest() {
        Project project = new Project.Builder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .withAddedProduct(true)
                .withShoppingCart(true)
                .build();
    }
}
