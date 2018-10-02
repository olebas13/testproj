import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    WebDriver driver;
    SignUpPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.spotify.com/int/signup");
    }

    @Test


    @After
    public void tearDown() {
        driver.quit();
    }
}
