package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateProjectPage extends BasePage {
    public static final SelenideElement INPUT_TITLE_FIELD = $("#inputTitle");
    public static final SelenideElement INPUT_CODE_FIELD = $("#inputCode");
    public static final SelenideElement INPUT_DESCRIPTION_FIELD = $("#inputDescription");
    public static final SelenideElement CREATE_PROJECT_BUTTON = $("[type='submit']");

    //    Project access type
    String inputProjectAccessTypeField = "#private-access-type"; //Default Private

    public String projectAccessType(String accessType) {
        switch (accessType) {
            case "Private":
                inputProjectAccessTypeField = "#private-access-type";
                break;
            case "Public":
                inputProjectAccessTypeField = "#public-access-type";
                break;
        }
        return inputProjectAccessTypeField;
    }

    //    Members access
    String inputMembersAccessTypeField = "#private-access-type"; //Default Private

    public String membersAccessType(String membersAccessType) {
        switch (membersAccessType) {
            case "All":
                inputMembersAccessTypeField = "#accessAll";
                break;
            case "Group":
                inputMembersAccessTypeField = "#accessGroup";
                break;
            case "None":
                inputMembersAccessTypeField = "#accessNone";
                break;
        }
        return inputMembersAccessTypeField;
    }

    @Step("Create new Project")
    public ProjectsDetailsPage createProject(Project project) {
        log.info("Creating new Project");
        String projectAccessType = project.getAccessType();
        String membersAccessType = project.getMembersAccessType();
        log.info(String.format("Writing text: %s into the Project Name field", project.getProjectName()));
        INPUT_TITLE_FIELD.sendKeys(project.getProjectName());
        log.info(String.format("Writing text: %s into the Project Code field", project.getProjectCode()));
        INPUT_CODE_FIELD.sendKeys(project.getProjectCode());
        log.info(String.format("Writing text: %s into Description field", project.getDescription()));
        INPUT_DESCRIPTION_FIELD.sendKeys(project.getDescription());
        log.info(String.format("Setting Project Access Type: %s", projectAccessType));
        $(projectAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
            log.info(String.format("Setting Members Access Type: %s", membersAccessType));
            $(membersAccessType(membersAccessType)).click();
        }
        CREATE_PROJECT_BUTTON.click();
        $("#project-avatar-container").shouldBe(Condition.visible);
        return new ProjectsDetailsPage();
    }

    @Override
    public boolean isPageOpened() {
        return isExist(CREATE_PROJECT_BUTTON);
    }
}
