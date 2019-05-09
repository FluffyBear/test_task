package com.wrike;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestTask extends WebDriverSettings {

    @Test
    public void test() {
        BasePageTest base = PageFactory.initElements(driver, BasePageTest.class);
        base.createAccount();

        ResendPageTest resend = PageFactory.initElements(driver, ResendPageTest.class);
        resend.checkPage();
        resend.checkQASection();
        resend.checkResendButton();

        FooterPageTest footer = PageFactory.initElements(driver, FooterPageTest.class);
        footer.scroll();
        footer.checkTwitterButton();
    }
}
