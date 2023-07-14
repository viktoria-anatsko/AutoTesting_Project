import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configurations.ReadProperties;

public class LocatorsHomeWorkTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void basicTest() {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.id("top-s")).sendKeys("paints\n");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.tagName("strong"));
        driver.findElement(By.linkText("Доставка")).click();
        driver.findElement(By.partialLinkText("Бонусная ")).click();
        driver.findElement(By.className("dark")).click();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get(ReadProperties.getUrl());

        Assert.assertTrue(driver.findElement(By.cssSelector("#search-top")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".top-panel__hnav__spec")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-init-scroll")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("strong")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.footer-full__address")).isDisplayed());
        Assert.assertEquals(9, driver.findElements(By.cssSelector("#top-page .category_goods_wrapper")).size());
        Assert.assertEquals(16, driver.findElements(By.cssSelector("form, button")).size());
        Assert.assertEquals(73, driver.findElements(By.cssSelector("div > ul")).size());
        Assert.assertEquals(12, driver.findElements(By.cssSelector("div + a")).size());
        Assert.assertEquals(87, driver.findElements(By.cssSelector("ul ~ div")).size());
        Assert.assertEquals(95, driver.findElements(By.cssSelector("[type]")).size());
        Assert.assertEquals(7, driver.findElements(By.cssSelector("[role='button']")).size());
        Assert.assertEquals(8, driver.findElements(By.cssSelector("[id$='Link']")).size());
        Assert.assertEquals(4, driver.findElements(By.cssSelector("[id^='p']")).size());
        Assert.assertEquals(5, driver.findElements(By.cssSelector("[id|='auth']")).size());
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~='Интернет-магазин']")).size());
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[title*='OZ']")).size());
        Assert.assertEquals(3, driver.findElements(By.cssSelector(":disabled")).size());
        Assert.assertEquals(166, driver.findElements(By.cssSelector(":enabled")).size());
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());
        Assert.assertEquals(2, driver.findElements(By.cssSelector("strong:first-child")).size());
        Assert.assertEquals(5, driver.findElements(By.cssSelector("form:last-child")).size());
        Assert.assertEquals(15, driver.findElements(By.cssSelector("ul:nth-child(3)")).size());
    }

    @Test
    public void xpathLocatorsTest() {
        driver.get(ReadProperties.getUrl());

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='top-page']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='submit' and @class='top-panel__search__btn']"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'search')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'main-ofs__col-1')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='напишите нам' and @class='dark border']"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Закажите звонок')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer-full']/a[1]")).isDisplayed());
    }

    @Test
    public void axesXpathTest() {
        driver.get(ReadProperties.getUrl());

        Assert.assertTrue(driver.findElement(By.xpath("//button/parent::span")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*/ancestor::*[@type='submit']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li/child::span[@title]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span/descendant::button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='top-panel__userbar']/following::form"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='top-panel__userbar']/following-sibling::form"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='global-ppnavlist']/preceding::form"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='global-ppnavlist']/preceding-sibling::a"))
                .isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
