package pages;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.TableRadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends BasePage {
    private final static String pagePath = "index.php?/admin/projects/edit/1/1";

    private final By headerTitleLabelLocator = By.id("content-header");
    private final By projectCheckBoxLocator = By.id("show_announcement");
    private final By radioButtonTableLocator = By.xpath("//div[@class='tab tab1  dirty-trackable']/div[7]");

    public EditProjectPage(WebDriver driver) {
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

    public CheckBox getProjectCheckBox() {
        return new CheckBox(driver, projectCheckBoxLocator);
    }

    public TableRadioButtons getRadioButtonTable() {
        return new TableRadioButtons(driver, radioButtonTableLocator);
    }
}
