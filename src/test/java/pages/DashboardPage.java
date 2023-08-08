package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard/";

    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private final By projectNameLocator = By.xpath("//*[@href='index.php?/projects/overview/1']");

    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
        sideMenuPage = new SideMenuPage(driver);
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

    public WebElement getProjectName() {
        return driver.findElement(projectNameLocator);
    }
}
