package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportsBookPage extends BasePage {

    @FindBy(xpath = "//button[.='Place bet']")
    private WebElement placeBetButton;

    @FindBy(xpath = "//div[@class='bet-complete']/h2")
    private WebElement betMessage;

    @FindBy(xpath = "//button[.='Clear cart']")
    private WebElement clearCart;


    public WebElement getClearCart() {
        BrowserUtils.waitClickability(clearCart, 10);
        return clearCart;
    }

    public WebElement getBetMessage() {
        BrowserUtils.waitForVisibility(betMessage, 10);
        return betMessage;
    }

    public WebElement getPlaceBetButton() {
        BrowserUtils.waitClickability(placeBetButton, 10);
        return placeBetButton;
    }

    /**
     * The method "getSportsCategory" takes a string parameter "categoryName"("Football","American Football","Hockey"),
     * and returns the selected name of the category
     *
     * @param categoryName
     * @return WebElement selectedCategory
     */
    public WebElement getSportsCategory(String categoryName) {

        WebElement selectedCategory = Driver.getDriver().findElement(By.xpath("//ul[@class='sports-categories']/li[.='" + categoryName + "']"));
        BrowserUtils.waitClickability(selectedCategory, 10);
        return selectedCategory;

    }

    /**
     * The method "getSportsBetOdd" takes two string parameters: "gameTeam" and "odd"("1","2","3")
     * It returns the selected game team competition and the corresponding betting odds
     * <p>
     * Odd number 1 denotes a home win
     * Odd number 2 signifies a tie
     * Odd number 3 denotes an away win
     *
     * @param gameTeam
     * @param odd
     * @return WebElement selectedBetOdd
     */

    public WebElement getSportsBetOdd(String gameTeam, String odd) {

        WebElement selectedBetOdd = Driver.getDriver().findElement(By.xpath("//div[@class='game']/div/div[.='" + gameTeam + "']/../div[2]/button[" + odd + "]"));

        return selectedBetOdd;

    }

    /**
     * The method "getSportsTournament" takes a string parameter "tournament"
     * which specifies the name of the tournament, such as "NFL" or "NHL"
     * The method then returns the name of the selected tournament
     *
     * @param tournamaentName
     * @return WebElement selectedTournament
     */

    public WebElement getSportsTournament(String tournamaentName) {

        WebElement selectedTournament = Driver.getDriver().findElement(By.xpath(" //li[.='" + tournamaentName + "']"));
        BrowserUtils.waitClickability(selectedTournament, 10);
        return selectedTournament;
    }


    /**
     * The method "getAdjustAmountButton" takes a string parameter "buttonIcon",
     * where "buttonIcon" refers to the icon "+" or "-"
     * The method then returns the corresponding icon as a WebElement
     *
     * @param buttonIcon
     * @return WebElement selectedadjustAmountButton
     */
    public WebElement getAdjustAmountButton(String buttonIcon) {

        WebElement selectedAdjustAmountButton = Driver.getDriver().findElement(By.xpath(" //button[.='" + buttonIcon + "']"));
        BrowserUtils.waitClickability(selectedAdjustAmountButton, 10);
        return selectedAdjustAmountButton;
    }


    /**
     * The method "setBetAmount" takes an integer parameter "amount" and a string parameter "buttonItem"
     * It adjusts the amount of money entered using the specified buttonItem icon.
     *
     * @param amount
     * @param buttonItem
     */
    public void setBetAmount(int amount, String buttonItem) {

        while (amount != 0) {
            getAdjustAmountButton(buttonItem).click();
            amount--;
        }


    }


}
