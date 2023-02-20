package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LotteryTicketPage extends BasePage {


    Select option;

    @FindBy(xpath = "//button[.='Buy tickets']")
    private WebElement buyTicketButton;

    @FindBy(xpath = "//div[@class='button-wrapper']/button")
    private WebElement addAnotherTicketButton;

    public WebElement getBuyTicketButton() {
        BrowserUtils.waitClickability(buyTicketButton, 10);
        return buyTicketButton;
    }

    public WebElement getAddAnotherTicketButton() {
        BrowserUtils.waitClickability(addAnotherTicketButton, 10);
        return addAnotherTicketButton;
    }

    /**
     * The method "selectDrawsAmount",which is to choose an amount("€5","€10","€15","€20","€25","€30","€35","€40","€45","€50")
     * from a dropdown list using the "selectByValue" method(value="1","2","3","4","5","6","7","8","9","10") of the Select class
     * at the same time, the value includes the number of draws
     *
     * @param drawsAmount
     */

    public void selectDrawsAmount(String drawsAmount) {

        option = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='form-input']")));
        option.selectByValue(drawsAmount);

    }

    /**
     * The method "getSelectedAmunt",return to choose an amount("€5","€10","€25","€50","€250")
     * from a dropdown list using the "selectByValue" method(value="5","10","25","50","250") of the Select class
     *
     * @return String filterAmount
     */
    public String getSelectedAmunt() {

        String selectedText = option.getFirstSelectedOption().getAttribute("text");
        String filterAmount = selectedText.substring(selectedText.indexOf("(") + 2, selectedText.lastIndexOf(")"));

        return filterAmount;

    }

    /**
     * The method "getLotteryTicket" takes an integer parameter "ticketNumber"
     * which indicates desired number of tickets
     * And, after adding the lucky ticket,
     * the method returns the selected ticket that the user has chosen to reveal the numbers
     *
     * @param ticketNumber
     * @return WebElement selectedicket
     */

    public WebElement getLotteryTicket(int ticketNumber) {

        WebElement selectedicket = Driver.getDriver().findElement(By.xpath("(//div[@class='row row--center-v'])[" + ticketNumber + "]/div[1]"));

        return selectedicket;

    }

    /**
     * The method 'getSelectedTicketNumberElement' takes an integer parameter 'ticketNumber'
     * and another integer parameter 'number',
     * which indicates the desired number of tickets to retrieve.
     * The method then returns the selected number of tickets value
     *
     * @param number
     * @param ticketNumber
     * @return WebElement selectedTicketNumberElement
     */

    public WebElement getSelectedTicketNumberElement(int number, int ticketNumber) {

        WebElement selectedTicketNumberElement = Driver.getDriver().findElement(By.xpath("((//div[@class='lottery-ticket'])[" + ticketNumber + "]/div/div/div['3'])[" + number + "]"));

        return selectedTicketNumberElement;
    }


}
