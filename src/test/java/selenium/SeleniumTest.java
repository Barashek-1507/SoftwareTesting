package selenium;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {

    static WebDriver driver;

    @BeforeAll
    static void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/maybach/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    @Order(1)
    void signUpTest() {
        driver.get("http://localhost:8282/registration");
        Assert.assertEquals("Registration", driver.getTitle());
        WebElement username = driver.findElement(By.cssSelector("#username"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[name=signUp]"));
        username.sendKeys("Roberr");
        password.sendKeys("roberrttt");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        submitButton.click();
        Assert.assertEquals("Registration", driver.getTitle());
    }

    @Test
    @Order(2)
    void singInTest() {
        driver.get("http://localhost:8282/login");
        WebElement username = driver.findElement(By.xpath("html/body/form/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("html/body/form/div[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        username.sendKeys("Roberr");
        password.sendKeys("roberrttt");
        submitButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("Greeting", driver.getTitle());
    }
}
