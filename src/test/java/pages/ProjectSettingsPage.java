package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static elements.Input.*;

@Log4j2
public class ProjectSettingsPage extends BasePage {

    @Step("Update the Project Name")
    public ProjectSettingsPage updateProjectName(String projectName) {
        SelenideElement element = $(inputTitleField);
        element.clear();
        element.sendKeys(projectName);
        return this;
    }

    @Step("Update the Project Code")
    public ProjectSettingsPage updateProjectCode(String projectCode) {
        SelenideElement element = $(inputCodeField);
        element.clear();
        element.sendKeys(projectCode);
        return this;
    }

    @Step("Update the Project Description")
    public ProjectSettingsPage updateProjectDescription(String projectDescription) {
        SelenideElement element = $(inputDescriptionField);
        element.clear();
        element.sendKeys(projectDescription);
        return this;
    }

    @Step("Click Update Settings")
    public ProjectSettingsPage submit() {
        $(createProjectButton).click();
        return this;
    }

    @Step("Check Update Alert")
    public ProjectSettingsPage checkAlert(String alertMessage) {
        $(".flash-message").shouldBe(Condition.visible).shouldHave(Condition.text(alertMessage));
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
