package pages;

import baseEntities.BasePage;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/projects/overview/1";

    private final By headerTitleLabelLocator = By.className("content-header-id");
    private final By navigationTestCasesLocator = By.cssSelector("#navigation-suites");

    public FirstProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public WebElement getNavigationTestCases() {
        return driver.findElement(navigationTestCasesLocator);
    }
}
