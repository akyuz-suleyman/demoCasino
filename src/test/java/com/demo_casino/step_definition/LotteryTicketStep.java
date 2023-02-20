package com.demo_casino.step_definition;

import com.demo_casino.pages.LotteryTicketPage;
import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class LotteryTicketStep {

    LotteryTicketPage lotteryTicketPage = new LotteryTicketPage();

    double balance;


    @Then("checks their account balance before buying a lottery ticket")
    public void checksTheirAccountBalanceBeforeBuyingALotteryTicket() {
        balance = Double.parseDouble(lotteryTicketPage.getBalance().getText().substring(1));
    }

    @Then("chooses to spend {string} on the ticket")
    public void choosesToSpendOnTheTicket(String drawAmount) {
        lotteryTicketPage.selectDrawsAmount(drawAmount);
    }

    @Then("purchases the lottery ticket")
    public void purchasesTheLotteryTicket() {
        lotteryTicketPage.getBuyTicketButton().click();
    }

    @And("the player should see that their balance has been updated after the purchase")
    public void thePlayerShouldSeeThatTheirBalanceHasBeenUpdatedAfterThePurchase() {
        BrowserUtils.waitClickability(lotteryTicketPage.getBuyTicketButton(), 5);
        double seletedBetAmount = Double.parseDouble(lotteryTicketPage.getSelectedAmunt());
        double expectedBalance = balance - seletedBetAmount;
        double seenAmount = Double.parseDouble(lotteryTicketPage.getBalance().getText().substring(1));

        Assert.assertEquals(expectedBalance, seenAmount, 2);
    }

    @Then("the player should be able to add another ticket to their current session")
    public void thePlayerShouldBeAbleToAddAnotherTicketToTheirCurrentSession() {

        lotteryTicketPage.getAddAnotherTicketButton().click();

        Assert.assertTrue(lotteryTicketPage.getLotteryTicket(2).isDisplayed());


    }

    @And("The player should not be able to select eight numbers on the ticket")
    public void thePlayerShouldNotBeAbleToSelectEightNumbersOnTheTicket(List<Integer> selectedLotteryNumbers) {

        for (int i = 0; i < selectedLotteryNumbers.size(); i++) {
            if (i <= 7) {
                lotteryTicketPage.getSelectedTicketNumberElement(selectedLotteryNumbers.get(i), 2).click();
            } else {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                String selectedScript = js.executeScript("return document.querySelector(\"#__layout > div > main > div.lottery-page > div > div.lottery-tickets > div:nth-child(2) > div > div > div:nth-child(8) > div\").classList").toString();
                Assert.assertFalse(selectedScript.contains("selected"));
            }

        }

    }


}