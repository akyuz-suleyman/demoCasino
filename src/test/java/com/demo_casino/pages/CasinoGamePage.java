package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CasinoGamePage extends BasePage {

    private Select option;

    private double betOutcome;

    @FindBy(css = ".prize-wrapper")
    private WebElement prizeWrapper;

    @FindBy(css = ".big")
    private WebElement winPrize;

    public WebElement getPrizeWrapper() {
        BrowserUtils.waitForVisibility(prizeWrapper, 10);
        return prizeWrapper;
    }

    public WebElement getWinPrize() {
        BrowserUtils.waitForVisibility(prizeWrapper, 10);
        return winPrize;
    }


    /**
     * The method "selectedBetAmount", which is to choose an amount("€5","€10","€25","€50","€250")
     * from a dropdown list using the "selectByValue" method(value="5","10","25","50","250") of the Select class
     *
     * @param amount
     */
    public void selectedBetAmount(String amount) {

        option = new Select(Driver.getDriver().findElement(By.xpath("//div[@class='game']/header/div[2]/select")));
        option.selectByValue(amount);

    }

    /**
     * The method "getselectedBetAmount",return to choose an amount("€5","€10","€25","€50","€250")
     * from a dropdown list using the "selectByValue" method(value="5","10","25","50","250") of the Select class
     *
     * @return String selectedAmount
     */
    public String getSelectedAmunt() {
        String selectedAmount = option.getFirstSelectedOption().getAttribute("value");
        return selectedAmount;
    }

    /**
     * The method "getSelectedCat" takes a parameter row and column which is to selected cat
     * The grid is arranged in a 2x2 format, with each cat represented by a div element
     * (1,1)means cat1
     * (1,2)means cat2
     * (2,1)means cat3
     * (2,2)means cat4
     *
     * @param row
     * @param column
     * @return WebElement catWebElement
     */
    public WebElement getSelectedCat(int row, int column) {

        WebElement catWebElement = Driver.getDriver().findElement(By.xpath("//div[@class='game__buttons']/div[" + row + "]/div[" + column + "]"));
        BrowserUtils.waitClickability(catWebElement, 10);
        return catWebElement;

    }

    /**
     * The outcome of this method is determined by the amount of the bet placed,
     * and the method returns the amount won or lost based on this bet
     *
     * @return double betOutCome
     */
    public double getBetOutcome() {


        String betOutcomeMessage = getPrizeWrapper().getAttribute("innerText");
        if (betOutcomeMessage.contains("Congratulations")) {
            betOutcome = Double.parseDouble(getWinPrize().getText().substring(1));
        } else {
            betOutcome = -Double.parseDouble(getSelectedAmunt());
        }
        return betOutcome;
    }

    /**
     * This method returns a message that indicates the outcome of the bet, whether the bet was a win or a loss
     *
     * @return String message
     */
    public String getConfirmMessage() {

        BrowserUtils.sleep(1);
        String message;
        message = getPrizeWrapper().getAttribute("outerText");

        return message;
    }


}
