package com.wrike;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    protected static WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "../test_task/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wrike.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
