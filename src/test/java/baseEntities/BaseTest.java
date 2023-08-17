package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AuthorizationStep;
import steps.ShoppingStep;
import utils.configurations.ReadProperties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected AuthorizationStep authorizationStep;
    protected ShoppingStep shoppingStep;

    static Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        org.apache.log4j.BasicConfigurator.configure();

        Configuration.baseUrl = ReadProperties.getUrl();

        authorizationStep = new AuthorizationStep();
        shoppingStep = new ShoppingStep();

        open("/");

        logger.info("Browser is started");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
