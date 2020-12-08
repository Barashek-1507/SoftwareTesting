package org.baggio.sweater.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\baggio\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://localhost:8888/login");
//        driver.get("https://www.sports.ru/");
    }

}
