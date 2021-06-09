package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Successful Login into {Configuration.baseUrl}")
    public void successfulLogin() {
        loginPage
                .openPage()
                .login(USER, PASSWORD)
                .isPageOpened();
    }
}
