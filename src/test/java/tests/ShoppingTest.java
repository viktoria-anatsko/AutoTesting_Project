package tests;

import baseEntities.BaseTest_;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ShoppingStep;
import utils.configurations.ReadProperties;


public class ShoppingTest extends BaseTest_ {

    @Test
    public void successShoppingTest() {
        Assert.assertEquals(
                shoppingStep.successShopping(), "1"
        );
    }

    @Test
    public void purchaseConfirmationTest() {
        Assert.assertTrue(
                shoppingStep.purchaseConfirmation().isPageOpened()
        );
    }

    @Test
    public void successCartInformationTest() {
        Assert.assertTrue(
                shoppingStep.successCartInformation().isPageOpened()
        );
    }

    @Test
    public void successFinishShoppingTest() {
        Assert.assertTrue(
                shoppingStep.successFinishShopping().isPageOpened()
        );
    }
}
