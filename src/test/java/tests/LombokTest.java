package tests;

import helper.DataHelper;
import models.User;
import models.UserBuilder;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public void toStringTest() {
        User user = DataHelper.getAdminUser();
        System.out.println(user.toString());
    }

    @Test
    public void builderTest() {
        UserBuilder user = UserBuilder.builder()
                .username("standard_user")
                .password("secret_sauce")
                .email("standard@gmail.com")
                .code("984")
                .build();

        System.out.println(user);
    }
}
