package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage
                .openPage()
                .login(USER, PASSWORD)
                .isPageOpened();
    }
}
