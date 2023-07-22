package steps;

import baseEntities.BaseStep_;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.InventoryPage;

public class AuthorizationStep extends BaseStep_ {

    public AuthorizationStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successAuthorization(String username, String psw) {
        authorizationPage.authorization(username, psw);

        return inventoryPage;
    }

    public AuthorizationPage negativeAuthorization(String username, String psw) {
        authorizationPage.authorization(username, psw);

        return authorizationPage;
    }
}
