import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public abstract class BaseTest {
    String USER, PASSWORD;

    @BeforeClass(description = "Open browser")
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        USER = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        PASSWORD = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;

    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        getWebDriver().quit();
    }
}

