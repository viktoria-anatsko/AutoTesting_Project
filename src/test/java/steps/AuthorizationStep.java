package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.InventoryPage;

public class AuthorizationStep extends BaseStep {

    public AuthorizationStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successAuthorization(String username, String psw) {
        authorizationPage.authorization(username, psw);

        return inventoryPage;
    }
}
