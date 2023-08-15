package steps;

import baseEntities.BaseStep;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.InventoryPage;

public class AuthorizationStep extends BaseStep {
    Logger logger = LogManager.getLogger(AuthorizationStep.class);

    public AuthorizationStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successAuthorization(String username, String psw) {
        authorizationPage.authorization(username, psw);

        logger.info("Success authorization is finished");
        return inventoryPage;
    }
}
