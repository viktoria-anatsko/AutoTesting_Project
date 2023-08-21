package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void set() {
        setCheckBoxFlag(true);
    }

    public void remove() {
        setCheckBoxFlag(false);
    }

    public void setCheckBoxFlag(boolean flag) {
        if (!isSelected() && flag) {
            uiElement.click();
        }
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }
}
