package com.demo_casino.step_definition;

import com.demo_casino.pages.SportsBookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SportsBooksStep {

    SportsBookPage sportsBookPage = new SportsBookPage();
    double balance;
    double betAmount;

    @Then("the player checks their account balance before betting on a sports event")
    public void thePlayerChecksTheirAccountBalanceBeforeBettingOnASportsEvent() {

        balance = Double.parseDouble(sportsBookPage.getBalance().getText().substring(1));

    }

    @Then("the player selects the desired {string} and {string}")
    public void thePlayerSelectsTheDesiredAnd(String sportsCategory, String sportsTournament) {
        sportsBookPage.getSportsCategory(sportsCategory).click();
        sportsBookPage.getSportsTournament(sportsTournament).click();
    }

    @Then("the player selects the {string} and {string}")
    public void thePlayerSelectsTheAnd(String gameteam, String betoption) {
        sportsBookPage.getSportsBetOdd(gameteam, betoption).click();
    }

    @Then("increases the bet amount by {int} using the {string} button")
    public void increasesTheBetAmountByUsingTheButton(int betamount, String buttonItem) {
        betAmount = betamount;
        sportsBookPage.setBetAmount(betamount, buttonItem);

    }

    @Then("places the bet on the selected sports event")
    public void placesTheBetOnTheSelectedSportsEvent() {
        sportsBookPage.getPlaceBetButton().click();
    }

    @Then("the player should see a {string} message")
    public void thePlayerShouldSeeAMessage(String message) {

        Assert.assertTrue(sportsBookPage.getBetMessage().getText().contains(message));

    }

    @Then("clicks the Clear cart button")
    public void clicksTheClearCartButton() {
        sportsBookPage.getClearCart().click();
    }

    @And("the player should be able to see that the balance has been updated after betting on a sports event")
    public void thePlayerShouldBeAbleToSeeThatTheBalanceHasBeenUpdatedAfterBettingOnASportsEvent() {
        double expectedBalance = balance - betAmount;
        double seenAmount = Double.parseDouble(sportsBookPage.getBalance().getText().substring(1));
        Assert.assertEquals(expectedBalance, seenAmount, 2);
    }


    @And("the player shouldn't see a {string} message")
    public void thePlayerShouldnTSeeAMessage(String message) {

        Assert.assertFalse(sportsBookPage.getBetMessage().getText().contains(message));

    }
}
