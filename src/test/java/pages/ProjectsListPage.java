package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import pages.base.BasePage;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsListPage extends BasePage {
    public static final String createNewProjectButton = "#createButton";
    public static final String searchInput = "[name='title']";
    public static final String projectsList = ".defect-title";
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

    @Step("Find project: {project.projectName} on Projects Page")
    public void projectShouldBeInProjectInList(Project project) {
        String projectName = project.getProjectName();
        log.info(String.format("Finding project: %s on Projects Page", projectName));
        $(searchInput).setValue(projectName);
        $$(projectsList).should(itemWithText(projectName));
        //Вопрос по коду ниже, как сделать через try-catch)
//        while(true) {
//            try {
//                $$(".defect-title").should(itemWithText(project.getProjectName()));
//                break;
//            } catch ( e) {
//                $(byXpath(nextPageButton)).click();
//                continue;
//            }
//        }
    }

    @Override
    public boolean isPageOpened() {
        return isExist($(userMenuAvatar));
    }
}
