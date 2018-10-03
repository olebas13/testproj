import org.junit.BeforeClass;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
        baseUrl = "https://www.spotify.com";
        browser = "firefox";
    }
}
