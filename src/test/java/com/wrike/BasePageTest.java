package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageTest {
    private BasePage basePage;

    public BasePageTest(WebDriver driver) {
        basePage = PageFactory.initElements(driver, BasePage.class);
    }

    public void createAccount() {
        basePage.getStarted();
        basePage.inputEmail();
        basePage.createAccount();
    }
}
