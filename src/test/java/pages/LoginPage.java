package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    public static final SelenideElement EMAIL_INPUT = $("#inputEmail");
    public static final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    @Step("Open Login page")
    public LoginPage openPage() {
        log.info("Opening Login page");
        open("login");
        return this;
    }

    @Step("Fill in the login form")
    public ProjectsPage login(String user, String password) {
        log.info("Filling in login form and press button login");
        EMAIL_INPUT.sendKeys(user);
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_BUTTON.click();
        USER_MENU_AVATAR.shouldBe(Condition.visible);
        return new ProjectsPage();
    }

    @Override
    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }
}