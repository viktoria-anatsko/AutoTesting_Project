package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AuthorizationStep;
import steps.ShoppingStep;
import utils.configurations.ReadProperties;

public class BaseTest_ {
    protected WebDriver driver;

    protected AuthorizationStep authorizationStep;
    protected ShoppingStep shoppingStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        authorizationStep = new AuthorizationStep(driver);
        shoppingStep = new ShoppingStep(driver);


        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
