package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // додайте цей аргумент для дозволу будь-яких походжень
        WebDriver driver = new ChromeDriver(options);


        driver.get("http://www.google.com");

        driver.quit();
    }
}