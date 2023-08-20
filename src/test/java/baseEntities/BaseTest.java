package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginStep;
import steps.ProjectStep;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected ProjectStep projectStep;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginStep = new LoginStep(driver);
        projectStep = new ProjectStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
