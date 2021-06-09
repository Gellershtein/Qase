package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.ProjectsDetailsPage;
import pages.ProjectsListPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public abstract class BaseTest {
    protected String USER, PASSWORD;
    protected LoginPage loginPage;
    protected ProjectsListPage projectsPage;
    protected CreateProjectPage createProjectPage;
    protected ProjectsDetailsPage projectsDetailsPage;

    @BeforeClass(description = "Open browser")
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        USER = utils.PropertyReader.getProperty("QASE_USER", "qase.user");
        PASSWORD = utils.PropertyReader.getProperty("QASE_PASSWORD", "qase.password");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
        projectsPage = new ProjectsListPage();
        createProjectPage = new CreateProjectPage();
        projectsDetailsPage = new ProjectsDetailsPage();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        getWebDriver().quit();
    }
}

