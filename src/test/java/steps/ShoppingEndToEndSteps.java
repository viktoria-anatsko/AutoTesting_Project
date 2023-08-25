package steps;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.configurations.ReadProperties;

public class ShoppingEndToEndSteps extends BaseTest {
    private BaseTest baseTest;
    private AuthorizationPage authorizationPage;
    private InventoryPage inventoryPage;
    private ShoppingCartContainerPage shoppingCartContainerPage;
    private CartPage cartPage;
    private CheckoutOnePage checkoutOnePage;
    private CheckoutTwoPage checkoutTwoPage;

    public ShoppingEndToEndSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("start browser")
    public void startBrowser() {
    }

    @Given("open authorization page")
    public void openAuthorizationPage() {
        driver.get(ReadProperties.getUrl());
    }

    @When("user enters username {} and password {}")
    public void setUsernameAndPassword(String username, String password) {
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.getUserNameInput().sendKeys(username);
        authorizationPage.getPswInput().sendKeys(password);
    }

    @When("user clicks login button")
    public void clickLoginButton() {
        authorizationPage.getLoginButton().click();
    }

    @When("user clicks addToCart button")
    public void clickAddToCartButton() {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
    }

    @When("user clicks shoppingCart")
    public void shoppingCart() {
        shoppingCartContainerPage = new ShoppingCartContainerPage(driver);
        shoppingCartContainerPage.clickToShoppingCartLink();
    }

    @When("user clicks checkout button")
    public void clickCheckoutButton() {
        cartPage = new CartPage(driver);
        cartPage.confirmPurchase();
    }

    @When("user enters firstname {} and lastname {} and zipCode {}")
    public void addUserInformation(String firstname, String lastname, String zipCode) {
        checkoutOnePage = new CheckoutOnePage(driver);
        checkoutOnePage.getFirstNameInput().sendKeys(firstname);
        checkoutOnePage.getLastNameInput().sendKeys(lastname);
        checkoutOnePage.getZipCodeInput().sendKeys(zipCode);
    }

    @When("user clicks continue button")
    public void clickContinueButton() {
        checkoutOnePage.clickContinueButton();
    }

    @When("user clicks finish button")
    public void clickFinishButton() {
        checkoutTwoPage = new CheckoutTwoPage(driver);
        checkoutTwoPage.finishShopping();
    }

    @Then("checkoutComplete page is displayed")
    public void isCheckoutCompletePageDisplayed() {
        Assert.assertTrue(new CheckoutCompletePage(driver).isPageOpened());
    }
}
