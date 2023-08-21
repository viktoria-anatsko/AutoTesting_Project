package tests;

import baseEntities.BaseTest;
import elements.DropDownMenu;
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

        driver.get("https://aqa21onl03.testrail.io/index.php?/admin/projects/edit/1/1");
        EditProjectPage editProjectPage = new EditProjectPage(driver);

        editProjectPage.getProjectCheckBox().set();

        editProjectPage.getProjectType().selectByIndex(2);
        editProjectPage.getProjectType().selectByText("Use multiple test suites to manage cases");
        editProjectPage.getProjectType().selectByValue("1");

    }

    @Test
    public void dropDownMenuTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        driver.get("https://aqa21onl03.testrail.io/index.php?/cases/add/2");

        TestCasesPage testCasesPage = new TestCasesPage(driver);

        DropDownMenu dropDownMenu = testCasesPage.getTemplateDropDown();
        dropDownMenu.selectByIndex(1);
        dropDownMenu.selectByText("Test Case (Steps)");

        dropDownMenu.getOptionsList().forEach(System.out::println);
    }
}
