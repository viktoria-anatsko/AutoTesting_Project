package pages;

import baseEntities.BasePage;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage extends FirstProjectPage {
    private final static String pagePath = "/index.php?/suites/view/1";

    private final By headerTitleLabelLocator = By.className("content-header-title");
    private final By addTestCaseButtonLocator = By.id("sidebar-cases-add");
    private final By templateDropDownLocator = By.id("template_id_chzn");

    public TestCasesPage(WebDriver driver) {
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

    public WebElement getAddTestCaseButton() {
        return driver.findElement(addTestCaseButtonLocator);
    }

    public DropDownMenu getTemplateDropDown() {
        return new DropDownMenu(driver, templateDropDownLocator);
    }
}
