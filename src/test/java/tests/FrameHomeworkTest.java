package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

public class FrameHomeworkTest extends BaseTest {

    @Test
    public void frameHWTest() {
            driver.get("http://the-internet.herokuapp.com/iframe");
            WaitService waitService = new WaitService(driver);

            driver.switchTo().frame("mce_0_ifr");

            Assert.assertEquals(waitService.waitForVisibilityLocatedBy(By.id("tinymce")).getText(),
                    "Your content goes here.");

            driver.switchTo().parentFrame();
    }
}
