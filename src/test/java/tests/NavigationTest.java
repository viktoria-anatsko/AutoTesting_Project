package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.configurations.ReadProperties;

public class NavigationTest extends BaseTest {

    @Test
    public void successLoginTest() {
        driver.get(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("atrostyanko@gmail.com");
        loginPage.getPswInput().sendKeys("Qwertyu_1");
        loginPage.getLogInButton().click();
    }
}
