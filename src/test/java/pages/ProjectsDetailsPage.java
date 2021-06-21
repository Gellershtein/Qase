package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsDetailsPage extends BasePage {
    public static final String testReviewButton = "[title='Test Review']";
    public static final String sharedStepsButton = "[title='Shared Steps']";
    public static final String milestonesButton = "[title='Milestones']";
    public static final String testPlansButton = "[title='Test Plans']";
    public static final String testRunsButton = "[title='Test Runs']";
    public static final String defectsButton = "[title='Defects']";
    public static final String requirementsButton = "[title='Requirements']";
    public static final String settingsButton = "[title='Settings']";

    @Step("Open Project Settings page by click")
    public ProjectSettingsPage openProjectSettingsPage() {
        $(settingsButton).click();
        log.info("Opening the Project Settings page");
        return new ProjectSettingsPage();
    }

    @Override
    public boolean isPageOpened() {
        return isExist($(userMenuAvatar));
    }
}
