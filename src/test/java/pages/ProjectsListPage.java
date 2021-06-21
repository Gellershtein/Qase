package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import pages.base.BasePage;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static elements.Input.createProjectButton;

@Log4j2
public class ProjectsListPage extends BasePage {
    public static final String createNewProjectButton = "#createButton";
    public static final String searchInput = "[name='title']";
    public static final String projectsList = ".defect-title";
    public static final String dropdownButton = ".btn-dropdown";
    public static final String dropdownOptions = "//a[@aria-expanded='true']//following::div[contains(@class,'dropdown-item')]/a[text()='%s']";
    public static final String notExistMessageLocator = ".no-project";
    String notExistMessage = "It looks like you don't have any projects yet.";

    String nextPageButton = "//span[text()='›']";

    public void clickCreateProjectButton() {
        $(createNewProjectButton).click();
    }

    @Step("Open Projects page")
    public ProjectsListPage openProjectsPage() {
        log.info("Opening the Projects page");
        open("projects");
        return this;
    }

    @Step("Open Project Settings page")
    public ProjectSettingsPage openProjectSettingsPage(Project project) {
//        log.info("Opening the Project Settings page");
//        open(String.format("project/%s/settings/general",project.getProjectCode()));
        open("project/" + project.getCode() + "/settings/general");
        return new ProjectSettingsPage();
    }

    @Step("Open Project Settings page by click")
    public ProjectSettingsPage openProjectSettingsPageByClick(Project project) {
        searchProject(project);
        $(projectsList).click();
        log.info("Opening the Project Settings page");
        return new ProjectSettingsPage();
    }

    @Step("Find project on Projects Page")
    public ProjectsListPage projectShouldBeInProjectInList(Project project) {
        searchProject(project);
        $$(projectsList).should(itemWithText(project.getTitle()));
        return this;
    }

    public ProjectsListPage searchProject(Project project) {
        String projectName = project.getTitle();
        log.info(String.format("Finding project: %s on Projects Page", projectName));
        $(searchInput).setValue(projectName);
        return this;
    }

    public ProjectsListPage clickDropdown() {
        $(dropdownButton).click();
        return this;
    }

    public ProjectsListPage selectDropdownOption(String option) {
        $(byXpath(String.format(dropdownOptions, option))).click();
        return this;
    }

    public ProjectsListPage isProjectExists(Project project) {
        searchProject(project);
        $(notExistMessageLocator).shouldBe(Condition.visible).shouldHave(Condition.text(notExistMessage));
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return isExist($(userMenuAvatar));
    }

    @Step("Click Update Settings")
    public ProjectsListPage submit() {
        $(createProjectButton).click();
        return this;
    }
}
