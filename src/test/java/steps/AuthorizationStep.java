package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.InventoryPage;

public class AuthorizationStep extends BaseStep {

    public AuthorizationStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successAuthorization(User user) {
        authorizationPage.authorization(user);

        return inventoryPage;
    }
}
