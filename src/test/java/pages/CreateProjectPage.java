package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static elements.Input.*;

@Log4j2
public class CreateProjectPage extends BasePage {

    String inputProjectAccessTypeField = "#private-access-type"; //Default Private
    String inputMembersAccessTypeField = "#accessAll"; //Default ALL for Private

    //    Project access type
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
        $(inputTitleField).sendKeys(project.getProjectName());
        log.info(String.format("Writing text: %s into the Project Code field", project.getProjectCode()));
        $(inputCodeField).sendKeys(project.getProjectCode());
        log.info(String.format("Writing text: %s into Description field", project.getDescription()));
        $(inputDescriptionField).sendKeys(project.getDescription());
        log.info(String.format("Setting Project Access Type: %s", projectAccessType));
        $(projectAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
            log.info(String.format("Setting Members Access Type: %s", membersAccessType));
            $(membersAccessType(membersAccessType)).click();
        }
        $(createProjectButton).click();
        $("#project-avatar-container").shouldBe(Condition.visible);
        return new ProjectsDetailsPage();
    }

    @Override
    public boolean isPageOpened() {
        return isExist($(createProjectButton));
    }
}
