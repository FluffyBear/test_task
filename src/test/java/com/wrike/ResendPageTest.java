package com.wrike;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResendPageTest {
    private ResendPage resendPage;

    public ResendPageTest(WebDriver driver) {
        resendPage = PageFactory.initElements(driver, ResendPage.class);
    }

    public void checkPage() {
        Assert.assertTrue(resendPage.isPageResend());
    }

    public void checkQASection() {
        resendPage.fillQASection();
        resendPage.submitResults();
        Assert.assertTrue(resendPage.resultsAreSubmit());
    }

    public void checkResendButton() {
        resendPage.resendEmail();
        Assert.assertTrue(resendPage.emailIsResend());
    }
}
