package pages;

import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage {
    public static String createProjectButton = "#createButton";
    String nextPageButton = "//span[text()='›']";

    public void clickCreateProjectButton() {
        $(createProjectButton).click();
    }

    public ProjectsPage openProjectsPage() {
        open("projects");
        return this;
    }

    public void findProjectInList(Project project) {
        $("[name='title']").setValue(project.getProjectName());
        $$(".defect-title").should(itemWithText(project.getProjectName()));
        //Вопрос по коду ниже, как сделать через трай кеч)
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
}
