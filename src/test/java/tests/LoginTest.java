package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        open("login");
        $("#inputEmail").sendKeys("USER");
        $("#inputPassword").sendKeys("PASSWORD");
        $("#btnLogin").click();
        $("#user-menu").shouldBe(Condition.visible);
    }
}
