package tests;

import adapters.ProjectAdapter;
import models.Project;
import models.ProjectFactory;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RestApiTest {

//    @Test
//    public void projectTests() {
//        String response = new ProjectAdapter().create("{}", 200);
//        assertEquals(response, "{\n" +
//                "    \"status\": false,\n" +
//                "    \"errorMessage\": \"Data is invalid\",\n" +
//                "    \"errorFields\": [\n" +
//                "        {\n" +
//                "            \"field\": \"title\",\n" +
//                "            \"error\": \"Title is required\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"field\": \"code\",\n" +
//                "            \"error\": \"Project code is required\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}");
//    }

    @Test
    @Ignore
    public void projectTests2() {
        Project project = Project.builder()
                .title("TEST6")
                .code("QERGDBWN")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithTitleAndCode() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject newProject = new ProjectAdapter().getProject(project.getCode());
        assertEquals(newProject.isStatus(), true);
        assertEquals(newProject.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithTitleCodeAndDescription() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject newProject = new ProjectAdapter().getProject(project.getCode());
        assertEquals(newProject.isStatus(), true);
        assertEquals(newProject.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithTitleCodeDescriptionAndAccess() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .access(ProjectFactory.get().getAccess())
                .group(ProjectFactory.get().getGroup())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject newProject = new ProjectAdapter().getProject(project.getCode());
        assertEquals(newProject.isStatus(), true);
        assertEquals(newProject.getResult().getCode(), project.getCode());
    }

    @Test
    public void createProjectWithTitleCodeDescriptionAccessAndGroup() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .description(ProjectFactory.get().getDescription())
                .access(ProjectFactory.get().getAccess())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject newProject = new ProjectAdapter().getProject(project.getCode());
        assertEquals(newProject.isStatus(), true);
        assertEquals(newProject.getResult().getCode(), project.getCode());
    }

    @Test
    @Ignore
    public void get() {
        ResponseProject project = new ProjectAdapter().getProject("WVUUKKVOJN");
        System.out.println(project);

    }
}
