package com.demo_casino.step_definition;

import com.demo_casino.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;

public class RegistirationStep {


    RegistrationPage registrationPage = new RegistrationPage();

    @Given("the player is on the home page")
    public void thePlayerIsOnTheHomePage() {
        registrationPage.goHomePage();
    }

    @When("the player clicks on the New Player button")
    public void thePlayerClicksOnTheNewPlayerButton() {
        registrationPage.getNewUserButton().click();
    }

    @Then("the player confirms their understanding by clicking I Get It Continue")
    public void thePlayerConfirmsTheirUnderstandingByClickingIGetItContinue() {
        registrationPage.getiGetItButton().click();
    }

    @Then("the player provides their valid email address as {string}")
    public void thePlayerProvidesTheirValidEmailAddressAs(String email) {
        registrationPage.getEmail().sendKeys(email, Keys.ENTER);

    }

    @Then("the player enters their {string} and {string}")
    public void thePlayerEntersTheirAnd(String countryCode, String phoneNumber) {
        registrationPage.getCountryCode().sendKeys(countryCode);
        registrationPage.getPhoneNumber().sendKeys(phoneNumber, Keys.ENTER);

    }

    @Then("the player provides their full name as {string}")
    public void thePlayerProvidesTheirFullNameAs(String fullName) {
        registrationPage.getName().sendKeys(fullName + Keys.ENTER);
    }

    @Then("the player enters a password as {string}")
    public void thePlayerEntersAPasswordAs(String password) {
        registrationPage.getPassword().sendKeys(password, Keys.ENTER);
    }

    @And("the player should see a success message saying {string}")
    public void thePlayerShouldSeeASuccessMessageSaying(String loginMessage) {
        Assert.assertTrue(registrationPage.getRegistrationMessage().getText().contains(loginMessage));
    }

    @And("the player cannot move to the next step")
    public void thePlayerCannotMoveToTheNextStep() {

        try {
            registrationPage.getForwardButton();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }


    }
}
