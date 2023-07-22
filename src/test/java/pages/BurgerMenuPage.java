package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage extends BasePage {
    private  final By burgerMenuLocator = By.id("react-burger-menu-btn");

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return burgerMenuLocator;
    }
}
