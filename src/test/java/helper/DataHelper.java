package helper;

import models.Project;
import models.User;
import utils.configurations.ReadProperties;

public class DataHelper {

    public static User getAdminUser() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getStandartUser() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static Project getCommonProject() {
        Project project = new Project.Builder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .withAddedProduct(true)
                .withShoppingCart(true)
                .build();

        return project;
    }
}
