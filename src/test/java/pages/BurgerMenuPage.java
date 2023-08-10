package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgerMenuPage extends BasePage {

    @FindBy (id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("react-burger-menu-btn");
    }
}
