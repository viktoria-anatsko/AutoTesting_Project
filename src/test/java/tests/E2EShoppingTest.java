package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.CheckoutCompletePage;
import utils.configurations.ReadProperties;


public class E2EShoppingTest extends BaseTest {

    @Test
    public void successShoppingTest() {

        new AuthorizationPage(driver)
                .setUserName(ReadProperties.username())
                .setPassword(ReadProperties.password())
                .successAuthorization()
                .addToCart()
                .clickToShoppingCart()
                .confirmPurchase()
                .addCartInformation()
                .clickToContinueButton()
                .finishShopping();

        Assert.assertTrue(new CheckoutCompletePage(driver).isPageOpened());
    }
}
