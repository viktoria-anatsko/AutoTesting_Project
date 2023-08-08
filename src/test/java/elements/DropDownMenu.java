package elements;

import org.checkerframework.checker.guieffect.qual.UI;
import org.checkerframework.checker.guieffect.qual.UIEffect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement uiElement;
    private WebDriver driver;
    private List<UIElement> dropDownItems;

    public DropDownMenu(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.dropDownItems = new ArrayList<>();

        for (UIElement element : uiElement.findUIElements(By.xpath("//parent::*/option"))) {
            dropDownItems.add(element);
        }
    }

    public void click() { uiElement.click();}

    public void getDropDownItem(String item) {

        for (UIElement element : dropDownItems) {
            if (element.getText().trim().contains(item)) {
                element.click();
            }
        }
    }
}
