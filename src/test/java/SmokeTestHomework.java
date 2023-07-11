import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SmokeTestHomework {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void calcSolelecTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("4");

        WebElement selectWebElement1 = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement1);

        selectRoomType.selectByIndex(1);
        sleep(2000);

        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement2);

        selectHeatingType.selectByVisibleText("Подогрев для комфорта");

        driver.findElement(By.cssSelector("#hf_calc > input")).click();
        sleep(2000);

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"),
                "763");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"),
                "64");
    }

    @Test
    public void calculatorLaminateTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select layingMethod = new Select(selectWebElement);

        layingMethod.selectByVisibleText("со смещение на 1/2 длины");
        sleep(2000);

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement laminateLength = driver.findElement(By.id("ln_lam_id"));
        laminateLength.clear();
        laminateLength.sendKeys("2000");

        WebElement laminateWidth = driver.findElement(By.id("wd_lam_id"));
        laminateWidth.clear();
        laminateWidth.sendKeys("200");

        driver.findElement(By.xpath("//*[@id=\"direction-laminate-id1\"]")).click();
        sleep(2000);
        driver.findElement(By.xpath("//a[@href=\"javascript:void(0);\"]")).click();

//        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='51']"))
//                .getAttribute("value"), "Требуемое количество досок ламината: 53", "Other value expected.");
//        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='7']"))
//                .getAttribute("value"), "Количество упаковок ламината: 7");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
