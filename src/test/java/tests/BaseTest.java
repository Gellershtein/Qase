package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public abstract class BaseTest {
    protected String USER, PASSWORD;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected CreateProjectPage createProjectPage;

    @BeforeClass(description = "Open browser")
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        USER = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        PASSWORD = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        createProjectPage = new CreateProjectPage();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
//        getWebDriver().quit();
    }
}

