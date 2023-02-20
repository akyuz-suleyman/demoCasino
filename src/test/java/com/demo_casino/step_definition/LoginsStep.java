package com.demo_casino.step_definition;

import com.demo_casino.pages.LoginPage;
import com.demo_casino.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginsStep {


    LoginPage loginPage = new LoginPage();

    @Then("the player clicks the Login button")
    public void thePlayerClicksTheLoginButton() {
        loginPage.getLoginButton().click();
    }

    @And("the player is on the {string} page")
    public void thePlayerIsOnThePage(String homePageTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), homePageTitle);
    }


}
