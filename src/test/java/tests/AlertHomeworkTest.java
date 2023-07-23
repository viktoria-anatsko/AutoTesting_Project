package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHomeworkTest extends BaseTest {

    @Test
    public void alertTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You selected a context menu");

        alert.accept();
    }
}
