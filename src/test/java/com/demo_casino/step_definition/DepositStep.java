package com.demo_casino.step_definition;

import com.demo_casino.pages.DepositPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DepositStep {

    DepositPage depositPage = new DepositPage();

    double balance;
    double depositamount;

    @Then("the player clicks on the Returning User button")
    public void thePlayerClicksOnTheReturningUserButton() {
        depositPage.getReturningUserButton().click();
    }

    @Then("the player checks their account balance before making a deposit")
    public void thePlayerChecksTheirAccountBalanceBeforeMakingADeposit() {
        balance = Double.parseDouble(depositPage.getBalance().getText().substring(1));
    }

    @Then("the player clicks on the money button")
    public void thePlayerClicksOnTheMoneyButton() {
        depositPage.getBalance().click();
    }

    @Then("the player selects the {string} deposit option")
    public void thePlayerSelectsTheDepositOption(String depositOption) {
        depositPage.getDepositOption(depositOption).click();
    }

    @Then("the player selects the {string} deposit amount")
    public void thePlayerSelectsTheDepositAmount(String depositAmount) {
        depositAmount = "€" + depositAmount;
        this.depositamount = Double.parseDouble(depositPage.getDepositAmount(depositAmount).getText().substring(1));
        depositPage.getDepositAmount(depositAmount).click();
    }

    @Then("the player confirms the deposit by selecting the {string} button")
    public void thePlayerConfirmsTheDepositBySelectingTheButton(String depositConfirm) {
        depositPage.getDepositConfirm(depositConfirm).click();
    }

    @Then("the player should see a success message saying {string} and then clicks OK button")
    public void thePlayerShouldSeeASuccessMessageSayingAndThenClicksOKButton(String message) {
        Assert.assertTrue(depositPage.getDepositMessage().getText().contains(message));
        depositPage.getDepositOkButton().click();
    }

    @And("the player should see that the account balance has been updated after deposit")
    public void thePlayerShouldSeeThatTheAccountBalanceHasBeenUpdatedAfterDeposit() {
        double expectedBalance = balance + depositamount;
        double seenAmount = Double.parseDouble(depositPage.getBalance().getText().substring(1));
        Assert.assertEquals(expectedBalance, seenAmount, 2);

    }

    @Then("the player should see a success message saying {string} and then clicks exit")
    public void thePlayerShouldSeeASuccessMessageSayingAndThenClicksExit(String message) {
        Assert.assertTrue(depositPage.getDepositMessage().getText().contains(message));
        depositPage.getExit().click();
    }

    @And("the player should see that the account balance has not been changed")
    public void thePlayerShouldSeeThatTheAccountBalanceHasNotBeenChanged() {
        double expectedBalance = balance;
        double seenAmount = Double.parseDouble(depositPage.getBalance().getText().substring(1));
        Assert.assertEquals(expectedBalance, seenAmount, 2);

    }


}
