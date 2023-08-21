package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.EditProjectPage;
import pages.LoginPage;

public class BaseStep {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected EditProjectPage editProjectPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        editProjectPage = new EditProjectPage(driver);
    }
}
