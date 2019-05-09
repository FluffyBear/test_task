package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//*[contains(@class, 'wg-header__desktop')]//*[contains(@class,'wg-header__free-trial-button')]")
    private WebElement getStartedButton;

    @FindBy(xpath = "//*[@id='modal-pro']//input[@name='email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//*[@id='modal-pro']//button[@type='submit']")
    private WebElement createAccountButton;

    public void getStarted() {
        getStartedButton.click();
    }

    public void inputEmail() {
        String random_text = UUID.randomUUID().toString();
        inputEmailField.sendKeys(random_text + "wpt@wriketask.qaa");
    }

    public void createAccount() {
        createAccountButton.click();
    }
}
