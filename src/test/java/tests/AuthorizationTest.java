package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;


public class AuthorizationTest extends BaseTest {

    @Test
    public void successAuthorizationTest() {
        Assert.assertTrue(
                authorizationStep.successAuthorization(
                        ReadProperties.username(), ReadProperties.password()
                ).isPageOpened()
        );
    }
}
