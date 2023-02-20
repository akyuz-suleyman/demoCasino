package com.demo_casino.step_definition;

import com.demo_casino.pages.CasinoGamePage;
import com.demo_casino.utilities.BrowserUtils;
import com.demo_casino.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class CasinoGameStep {

    CasinoGamePage casinoGamePage = new CasinoGamePage();
    double balance;

    @Then("the player checks their account balance before playing a casino game")
    public void thePlayerChecksTheirAccountBalanceBeforePlayingACasinoGame() {
        balance = Double.parseDouble(casinoGamePage.getBalance().getText().substring(1));
    }


    @Then("the player selects a {string} to play")
    public void thePlayerSelectsAToPlay(String casino) {
        casinoGamePage.getMenuItem().click();
        casinoGamePage.getSelectGame(casino).click();
    }

    @Then("the player selects the desired {string} from the bet options")
    public void thePlayerSelectsTheDesiredFromTheBetOptions(String amount) {
        casinoGamePage.selectedBetAmount(amount);
    }

    @Then("the player selects the cat at row {int} and column {int}")
    public void thePlayerSelectsTheCatAtRowRowAndColumnColumn(int row, int column) {
        casinoGamePage.getSelectedCat(row, column).click();
    }

    @Then("the player should see a confirmation message")
    public void thePlayerShouldSeeAConfirmationMessage() {
        String message = casinoGamePage.getConfirmMessage();
        Assert.assertFalse(message.equals(""));
    }

    @And("the player should see that their balance has been updated after playing a casino game")
    public void thePlayerShouldSeeThatTheirBalanceHasBeenUpdatedAfterPlayingACasinoGame() {

        double betOutcome = casinoGamePage.getBetOutcome();
        double expectedBalance = balance + betOutcome;
        double seenAmount = Double.parseDouble(casinoGamePage.getBalance().getText().substring(1));

        Assert.assertEquals(expectedBalance, seenAmount, 2);
    }

    @Then("the player should see alert {string} message")
    public void thePlayerShouldSeeAlertMessage(String alertMessage) {

        String actualMessage = BrowserUtils.getAlertMessage();
        String expectedMessage = alertMessage;
        Assert.assertEquals(expectedMessage, actualMessage);


    }
}
