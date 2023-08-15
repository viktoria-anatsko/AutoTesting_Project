package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(User user) {
        loginPage.login(user);

        return dashboardPage;
    }

    public LoginPage negativeLogin(User user) {
        loginPage.login(user);

        return loginPage;
    }
}
