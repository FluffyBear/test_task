package com.wrike;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FooterPageTest {
    private FooterPage footerPage;

    public FooterPageTest(WebDriver driver) {
        footerPage = PageFactory.initElements(driver, FooterPage.class);
    }

    public void scroll() {
        footerPage.scrollToBottomFooter();
    }

    public void checkTwitterButton() {
        footerPage.isTwitterButtonContains();
        Assert.assertTrue(footerPage.isTwitterUrlCorrect());
        Assert.assertTrue(footerPage.isTwitterIconCorrect());
    }
}
