package tests;

import baseEntities.BaseTest_;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;


public class AuthorizationTest extends BaseTest_ {

    @Test
    public void successAuthorizationTest() {
        Assert.assertTrue(
                authorizationStep.successAuthorization(
                        ReadProperties.username(), ReadProperties.password()
                ).isPageOpened()
        );
    }

    @Test
    public void lockedOutUserTest() {
        Assert.assertEquals(
                authorizationStep.negativeAuthorization("locked_out_user",
                        ReadProperties.password()).getErrorTextElement().getText(),
                        "Epic sadface: Sorry, this user has been locked out.");
    }
}
