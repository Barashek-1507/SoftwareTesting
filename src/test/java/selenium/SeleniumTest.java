package selenium;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    static WebDriver driver;

    @BeforeAll
    static void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\baggio\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
