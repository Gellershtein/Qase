package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import models.Project;
import pages.base.BasePage;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $("#createButton");
    public static final SelenideElement SEARCH_INPUT = $("[name='title']");
    public static final ElementsCollection PROJECTS_LIST = $$(".defect-title");
    String nextPageButton = "//span[text()='›']";

    public void clickCreateProjectButton() {
        CREATE_NEW_PROJECT_BUTTON.click();
    }

    public ProjectsPage openProjectsPage() {
        open("projects");
        return this;
    }

    public void findProjectInList(Project project) {
        SEARCH_INPUT.setValue(project.getProjectName());
        PROJECTS_LIST.should(itemWithText(project.getProjectName()));
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
        return isExist(USER_MENU_AVATAR);
    }
}
