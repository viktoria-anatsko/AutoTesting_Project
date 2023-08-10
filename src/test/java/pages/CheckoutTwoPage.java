package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutTwoPage extends InventoryPage {
    private final static String pagePath = "/checkout-step-two.html";

    @FindBy (id = "finish")
    public WebElement finishButton;

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("finish");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void finishShopping() {
        finishButton.click();
    }
}
