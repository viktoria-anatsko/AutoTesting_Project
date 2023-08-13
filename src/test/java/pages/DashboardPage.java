package pages;

import factory.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private final static String pagePath = "/index.php?/dashboard/";

    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;

    public DashboardPage() {
        topMenuPage = new TopMenuPage();
        sideMenuPage = new SideMenuPage();
    }

    public WebElement getHeaderTitle() {
        return BrowserSingleton.getInstance().driver.findElement(headerTitleLabelLocator);
    }

    public boolean isPageOpened() {
        return getHeaderTitle().isDisplayed();
    }
}
