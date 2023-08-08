package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;
    private WebDriver driver;

    public CheckBox(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public void setCheckBoxFlag() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public boolean isSetCheckBoxFlag() {
        return uiElement.isSelected();
    }

    public void removeCheckBoxFlag() {
        if (uiElement.isSelected()) {
            uiElement.click();
        }
    }
}
