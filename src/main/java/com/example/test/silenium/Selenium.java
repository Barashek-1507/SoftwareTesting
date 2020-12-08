package com.example.test.silenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/maybach/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://localhost:8282/login");
//        driver.get("https://javarush.ru/groups/posts/2081-putjh-programmista");
    }

}
