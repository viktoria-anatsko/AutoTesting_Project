package steps;

import baseEntities.BaseStep;
import pages.InventoryPage;

public class AuthorizationStep extends BaseStep {

    public AuthorizationStep() {
        super();
    }

    public InventoryPage successAuthorization(String username, String psw) {
        authorizationPage.authorization(username, psw);

        return inventoryPage;
    }
}
