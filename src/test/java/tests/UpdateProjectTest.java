package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;


public class UpdateProjectTest extends BaseTest {

    @Test(description = "Create new Project and find it on Products page")
    public void projectShouldBeCreated() {
        loginPage
                .openPage()
                .login(USER, PASSWORD)
                .clickCreateProjectButton();
        Project project = ProjectFactory.get();
        createProjectPage
                .createProject(project)
                .openProjectSettingsPage()
                .updateProjectName("Test")
                .submit()
                .checkAlert("Project settings were successfully updated!")
                .updateProjectCode("DFRTD")
                .checkAlert("Project settings were successfully updated!");
    }
}
