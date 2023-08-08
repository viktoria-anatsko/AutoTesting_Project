package pages;

import baseEntities.BasePage;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.className("page_title");
    private final By projectsTableLocator = By.cssSelector("#content-inner table");
    private final By editProjectLinkLocator = By.xpath("//*[@href='index.php?/admin/projects/edit/1/1']");

    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public WebElement getEditProjectLink() {
        return driver.findElement(editProjectLinkLocator);
    }

    public Table getProjectsTable() {
        return new Table(driver, projectsTableLocator);
    }
}
