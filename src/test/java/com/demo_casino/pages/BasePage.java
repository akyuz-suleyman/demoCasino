package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.ConfigurationReader;
import com.demo_casino.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goHomePage() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement forwardButton;
    @FindBy(xpath = "//div[@id='navigation']")
    private WebElement menuItem;

    @FindBy(xpath = "//button[.='Returning user']")
    private WebElement returningUserButton;
    @FindBy(xpath = "//button[@class='button money']")
    private WebElement balance;

    public WebElement getForwardButton() {
        return forwardButton;
    }

    public WebElement getMenuItem() {
        BrowserUtils.waitClickability(menuItem, 10);
        return menuItem;
    }

    public WebElement getReturningUserButton() {
        BrowserUtils.waitClickability(returningUserButton, 10);
        return returningUserButton;
    }

    public WebElement getBalance() {
        BrowserUtils.waitForVisibility(balance, 10);
        return balance;
    }

    /**
     * The method "getSelectGame" takes a parameter "gameName"
     * which is a string("casino","sportsbook","lottery") that represents the name of a game
     *
     * @param gameName
     * @return WebElement gameWebElement
     */
    public WebElement getSelectGame(String gameName) {
        WebElement gameWebElement = Driver.getDriver().findElement(By.xpath("//a[.='" + gameName + "']"));
        BrowserUtils.waitClickability(gameWebElement, 10);
        return gameWebElement;
    }


}
