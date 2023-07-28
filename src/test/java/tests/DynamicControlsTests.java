package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

public class DynamicControlsTests extends BaseTest {

    @Test
    @Description("Demonstration of changing element's status.")
    public void removeTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        WebElement checkbox = waitService.waitForVisibilityLocatedBy(By.id("checkbox"));
        Assert.assertFalse(checkbox.isSelected());

        actions
                .click(waitService.waitForVisibilityLocatedBy(By.xpath("//*[@onclick='swapCheckbox()']")))
                .perform();

        Assert.assertTrue(waitService.waitForVisibilityLocatedBy(By.id("message")).isDisplayed(), "It's gone!");
    }

    @Test
    @Description("Control of input field.")
    @Severity(SeverityLevel.BLOCKER)
    public void disabledTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WaitService waitService = new WaitService(driver);

        WebElement textInput = waitService.waitForExists(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textInput.isEnabled());

        WebElement enableButton = waitService.waitForExists(By.xpath("//*[@onclick='swapInput()']"));
        enableButton.click();
        Assert.assertTrue(waitService.waitForVisibilityLocatedBy(By.cssSelector("p#message")).isDisplayed(), "It's enabled!");
        Assert.assertTrue(textInput.isEnabled());
    }

    @Test
    @Description("Taking a screenshot when test fails.")
    public void screenShotTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertTrue(false);
    }
}
