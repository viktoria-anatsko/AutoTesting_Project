package tests;

import baseEntities.BaseTest;
import elements.CheckBox;
import elements.DropDownMenu;
import elements.TableRadioButtons;
import elements.UIElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.configurations.ReadProperties;

public class WrappersHomeworkTests extends BaseTest {

    @Test
    public void uiElementsTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getProjectName().click();

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.getEditProjectLink().click();

        EditProjectPage editProjectPage = new EditProjectPage(driver);
        editProjectPage.getProjectCheckBox();

        CheckBox checkBox = editProjectPage.getProjectCheckBox();
        checkBox.setCheckBoxFlag();

        Assert.assertTrue(checkBox.isSetCheckBoxFlag());

        checkBox.removeCheckBoxFlag();

        Assert.assertFalse(checkBox.isSetCheckBoxFlag());

        TableRadioButtons tableRadioButtons = editProjectPage.getRadioButtonTable();
        UIElement radioButton = tableRadioButtons.getRadioButton(1);
        radioButton.click();

        Assert.assertTrue(tableRadioButtons.isRadioButtonClick(radioButton));

        UIElement radioButton2 = tableRadioButtons.getRadioButton(2);
        radioButton2.click();

        Assert.assertFalse(tableRadioButtons.isRadioButtonClick(radioButton));
        Assert.assertTrue(tableRadioButtons.isRadioButtonClick(radioButton2));

        UIElement radioButtonText = tableRadioButtons.getRadioButtonByName("Use a single repository with baseline support");
        radioButtonText.click();
        Assert.assertTrue(tableRadioButtons.isRadioButtonClick(radioButtonText));

        UIElement radioButtonValue = tableRadioButtons.getRadioButtonByValue("Multiple test suites");
        radioButtonValue.click();
        Assert.assertTrue(tableRadioButtons.isRadioButtonClick(radioButtonValue));
    }

    @Test
    public void dropDownMenuTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        FirstProjectPage firstProjectPage = new FirstProjectPage(driver);
        firstProjectPage.openPageByUrl();

        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.getAddTestCaseButton().click();

        DropDownMenu dropDownMenu = testCasesPage.getTemplateDropDown();
        dropDownMenu.click();
        dropDownMenu.getDropDownItem("Session");

    }
}
