package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public ProjectsDetailsPage createProject(Project project) {
        String projectAccessType = project.getAccessType();
        String membersAccessType = project.getMembersAccessType();

        INPUT_TITLE_FIELD.sendKeys(project.getProjectName());
        INPUT_CODE_FIELD.sendKeys(project.getProjectCode());
        INPUT_DESCRIPTION_FIELD.sendKeys(project.getDescription());
        $(projectAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
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
