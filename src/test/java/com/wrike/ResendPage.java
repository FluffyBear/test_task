package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ResendPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ResendPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//div[@class='survey']//button[@type='submit']")
    private WebElement submitResultsButton;

    @FindBy(xpath = "//div[@class='wg-grid']//*[contains(text(), 'Resend email')]")
    private WebElement resendEmailButton;

    @FindBy(xpath = "//img[@class='mailbox']")
    private WebElement mailBoxImage;

    @FindBy(xpath = "//div[@data-code='interest_in_solution']/child::label")
    private List<WebElement> interestInSolution;

    @FindBy(xpath = "//div[@data-code='team_members']/child::label")
    private List<WebElement> teamMembers;

    @FindBy(xpath = "//div[@data-code='primary_business']/child::label")
    private List<WebElement> primaryBusiness;

    @FindBy(xpath = "//div[@data-code='primary_business']//input[@type='text']")
    private WebElement commentInput;

    public boolean isPageResend() {
        wait.until(ExpectedConditions.visibilityOf(resendEmailButton));
        String url = driver.getCurrentUrl();
        return (url.equals("https://www.wrike.com/resend/"));
    }

    public void fillQASection() {
        WebElement firstAnswer = interestInSolution.get(new Random().nextInt(interestInSolution.size()));
        firstAnswer.click();
        WebElement secondAnswer = teamMembers.get(new Random().nextInt(teamMembers.size()));
        secondAnswer.click();
        int thirdNumber = new Random().nextInt(primaryBusiness.size());
        WebElement thirdAnswer = primaryBusiness.get(thirdNumber);
        thirdAnswer.click();
        if (thirdNumber == primaryBusiness.size() - 1) {
            commentInput.sendKeys("123");
        }
    }

    public void submitResults() {
        submitResultsButton.click();
    }

    public boolean resultsAreSubmit() {
        wait.until(ExpectedConditions.visibilityOf(mailBoxImage));
        return mailBoxImage.isDisplayed();
    }

    public void resendEmail() {
        resendEmailButton.click();
    }

    public boolean emailIsResend() {
        wait.until(ExpectedConditions.invisibilityOf(resendEmailButton));
        return !resendEmailButton.isDisplayed();
    }
}
