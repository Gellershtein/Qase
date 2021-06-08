package pages;

import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage {
    public static String createProjectButton = "#createButton";

    public void clickCreateProjectButton() {
        $(createProjectButton).click();
    }

    public ProjectsPage openProjectsPage() {
        open("projects");
        return this;
    }

    public void findProjectInList(Project project) {
        $$(".defect-title").should(itemWithText(project.getProjectName()));
    }
}
