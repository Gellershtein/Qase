package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;


public class CreateNewProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage
                .openPage()
                .login(USER, PASSWORD)
                .clickCreateProjectButton();
        Project project = ProjectFactory.get();
        createProjectPage
                .createProject(project)
                .isPageOpened();
        projectsPage
                .openProjectsPage()
                .findProjectInList(project);
    }
}
