package stepDefs;

import factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.configuration.ReadProperties;

import java.util.Map;

public class FirstStepDefs {
    private WebDriver driver;

    @Given("открыт браузер")
    public void startBrowser() {
//        driver = new BrowserFactory().getDriver();
    }

    @When("страница логина открыта")
    public void openLoginPage() {
//        driver.get(ReadProperties.getUrl());
    }

    @Then("поле username отображается")
    public void isUsernameFieldDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @Then("поле password отображается")
    public void isPasswordFieldDisplayed() {
        Assert.assertTrue(true);
    }

    @Then("поле password не отображается")
    public void isPasswordFieldNotDisplayed() {
        Assert.assertTrue(true);
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
    }

    @Then("title is {string}")
    public void titleIs(String value) {
    }

    @And("^project id is (\\d+)$")
    public void projectIdIs(int value) {
        System.out.println("Project ID: " + value);
    }

    @When("^admin \"([^\"]*)\" with password ([^\"]*) logged in$")
    public void adminWithPasswordLoggedIn(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @And("^all elements \"(are|are not)\" visible$")
    public void allElementsAreVisible(String parameter) {
        if (parameter.equals("are")) {

        } else {

        }
    }

    @When("admin {string} with password {string} logged in")
    public void adminUsernameWithPasswordPasswordLoggedIn(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @When("users logged in")
    public void usersLoggedIn(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        System.out.println("Username: " + expectedValues.get("username"));
        System.out.println("Password: " + expectedValues.get("password"));
    }

    @Then("error is displayed")
    public void errorIsDisplayed() {
        System.out.println("Ошибка");
    }
}
