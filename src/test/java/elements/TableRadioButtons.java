package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TableRadioButtons {
    private UIElement uiElement;
    private WebDriver driver;
    private List<UIElement> cellRadioButtons;

    public TableRadioButtons(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.cellRadioButtons = new ArrayList<>();

        for (UIElement element : uiElement.findUIElements(By.cssSelector(".column.project-type"))) {
            cellRadioButtons.add(element);
        }
    }

    public UIElement getRadioButton(int index) {
        return cellRadioButtons.get(index).findElement(By.tagName("input"));
    }

    public boolean isRadioButtonClick(UIElement radioButton) {
        return radioButton.isSelected();
    }

    public UIElement getRadioButtonByName(String radioButtonName) {

        for (UIElement cell : cellRadioButtons) {
            UIElement tagStrong = cell.findElement(By.tagName("strong"));
            if (tagStrong.getText().equals(radioButtonName)) {
                return cell.findElement(By.tagName("input"));
            }
        } return null;
    }

    public UIElement getRadioButtonByValue(String value) {

        for (UIElement cell : cellRadioButtons) {
            UIElement description = cell.findElement(By.tagName("p"));
            if (description.getText().contains(value)) {
                return cell.findElement(By.tagName("input"));
            }
        } return null;
    }
}
