package tests;

import com.codeborne.selenide.Condition;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CreateNewProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage
                .openPage()
                .login(USER,PASSWORD)
                .clickCreateProjectButton();
        Project project = ProjectFactory.get();
        createProjectPage
                .createProject(project);
        projectsPage
                .openProjectsPage()
                .findProjectInList(project);
    }
}
