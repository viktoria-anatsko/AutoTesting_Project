package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitService;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement uiElement;
    private UIElement actionElement;
    private UIElement optionsElement;
    private WaitService waitService;
    private List<UIElement> optionList = new ArrayList<>();
    private List<String> textList = new ArrayList<>();

    public DropDownMenu(WebDriver driver, By by) {
        this.waitService = new WaitService(driver);
        this.uiElement = new UIElement(driver, by);
        this.actionElement = waitService.waitForVisibility(uiElement.findElement(By.tagName("a")));
        this.optionsElement = uiElement.findElement(By.className("chzn-drop"));
    }

    private void open() {
        actionElement.click();
        waitService.waitForVisibility(optionsElement);
        for (UIElement element:
        uiElement.findUIElements(By.tagName("li"))) {
            optionList.add(element);
        }
        optionList.forEach(element -> textList.add(element.getText()));
    }

    public void selectByText(String text) {
        open();
        optionList.get(textList.indexOf(text)).click();
    }

    public void selectByIndex(int index) {
        open();
        optionList.get(index).click();
    }

    public List<String> getOptionsList() {
        open();
        actionElement.click();
        return textList;
    }
}
