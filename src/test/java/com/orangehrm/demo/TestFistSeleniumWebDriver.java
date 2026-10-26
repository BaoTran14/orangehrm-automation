package com.orangehrm.demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestFistSeleniumWebDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resouces/drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver(); // Open browser(chrome)
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Access website address (google)
    }
}