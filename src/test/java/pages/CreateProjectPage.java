package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateProjectPage {
    public String inputTitleField = "#inputTitle";
    public String inputCodeField = "#inputCode";
    public String inputDescriptionField = "#inputDescription";
    public String createProjectButton = "[type='submit']";

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

    public void createProject(Project project) {
        String projectAccessType = project.getAccessType();
        String membersAccessType = project.getMembersAccessType();
        $(inputTitleField).sendKeys(project.getProjectName());
        $(inputCodeField).sendKeys(project.getProjectCode());
        $(inputDescriptionField).sendKeys(project.getDescription());
        $(projectAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
            $(membersAccessType(membersAccessType)).click();
        }
        $(createProjectButton).click();
        $("#project-avatar-container").shouldBe(Condition.visible);
    }
}
