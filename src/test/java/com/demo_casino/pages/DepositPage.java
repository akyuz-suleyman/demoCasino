package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {


    @FindBy(xpath = "//button[.='OK']")
    private WebElement depositOkButton;

    @FindBy(xpath = "//div[@class='modal__x']")
    private WebElement exit;

    @FindBy(xpath = "//div[@class='modal']/div[2]/div/div[2]/div[4]/h3")
    private WebElement depositMessage;

    public WebElement getDepositOkButton() {
        BrowserUtils.waitClickability(depositOkButton, 10);
        return depositOkButton;
    }

    public WebElement getExit() {
        BrowserUtils.waitClickability(exit, 10);
        return exit;
    }

    public WebElement getDepositMessage() {
        BrowserUtils.waitForVisibility(depositMessage, 10);
        return depositMessage;
    }


    /**
     * The method "getDepositOption" takes an String parameter "depositOption"
     * indicating the desired deposit option and returns the corresponding option
     * Available options include "Card", "Direct Bank", and "E-Wallet"
     *
     * @param depositOption
     * @return WebElement selectedDepositOption;
     */
    public WebElement getDepositOption(String depositOption) {

        WebElement selectedDepositOption = Driver.getDriver().findElement(By.xpath("//button[.='" + depositOption + "']"));
        return selectedDepositOption;

    }

    /**
     * This method "getDepositAmount" takes an string parameter "depositAmount"("€10","€50","€100","€500")
     * indicating the desired deposit amount and returns the selected amount
     *
     * @param depositAmount
     * @return WebElement selectedDepositAmount;
     */

    public WebElement getDepositAmount(String depositAmount) {

        WebElement selectedDepositAmount = Driver.getDriver().findElement(By.xpath("//button[.='" + depositAmount + "']"));
        return selectedDepositAmount;
    }

    /**
     * The method "getDepositConfirm" takes an String parameter "depositConfirm"
     * this method returns the deposit information message
     *
     * @param depositConfirm
     * @return WebElement selectedDepositConfirm
     */
    public WebElement getDepositConfirm(String depositConfirm) {

        WebElement selectedDepositConfirm = Driver.getDriver().findElement(By.xpath("//button[.='" + depositConfirm + "']"));

        return selectedDepositConfirm;
    }


}
