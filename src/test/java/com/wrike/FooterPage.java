package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//div[@class='wg-footer__bottom-section']")
    private WebElement bottomFooter;

    @FindBy(xpath = "//*[@class='wg-footer__social-list']//a[contains(@href,'twitter')]//*[@class='wg-footer__social-icon']")
    private WebElement twitterButton;

    @FindBy(xpath = "//*[@class='wg-footer__social-list']//a[contains(@href,'twitter')]")
    private WebElement twitterUrl;

    public void scrollToBottomFooter () {
        Actions actions = new Actions(driver);
        actions.moveToElement(bottomFooter).perform();
    }

    public void isTwitterButtonContains() {
        wait.until(ExpectedConditions.visibilityOf(twitterButton));
    }

    public boolean isTwitterUrlCorrect() {
        String url = twitterUrl.getAttribute("href");
        return url.equals("https://twitter.com/wrike");
    }

    public boolean isTwitterIconCorrect() {
        boolean isCorrect = twitterButton.isDisplayed();
        return isCorrect;
    }

}
