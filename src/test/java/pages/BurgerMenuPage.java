package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class BurgerMenuPage extends BasePage {
    private  final By burgerMenuLocator = By.id("react-burger-menu-btn");

    public BurgerMenuPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return burgerMenuLocator;
    }
}
