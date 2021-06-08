package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    public static final String LOGIN_BUTTON = "#btnLogin";

    @Step("Open Login page")
    public LoginPage openPage() {
        log.info("Opening Login page");
        open("login");
        return this;
    }

    @Step("Fill in the login form")
    public ProjectsPage login(String user, String password) {
        log.info("Filling in login form and press button login");
//        open("login");
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
        $("#user-menu").shouldBe(Condition.visible);
        return new ProjectsPage();
    }
}