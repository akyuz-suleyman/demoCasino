package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//button[.='New user']")
    private WebElement newUserButton;

    @FindBy(xpath = "//button[.='I GET IT, CONTINUE']")
    private WebElement iGetItButton;

    @FindBy(css = "input.input")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='+46']")
    private WebElement countryCode;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Enter your name']")
    private WebElement name;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(tagName = "h3")
    private WebElement registrationMessage;


    public WebElement getNewUserButton() {
        BrowserUtils.waitClickability(newUserButton, 10);
        return newUserButton;
    }

    public WebElement getiGetItButton() {
        BrowserUtils.waitClickability(iGetItButton, 10);
        return iGetItButton;
    }

    public WebElement getEmail() {
        BrowserUtils.waitForVisibility(email, 10);
        return email;
    }

    public WebElement getCountryCode() {
        BrowserUtils.waitForVisibility(countryCode, 10);
        return countryCode;
    }

    public WebElement getPhoneNumber() {
        BrowserUtils.waitForVisibility(phoneNumber, 10);
        return phoneNumber;
    }

    public WebElement getName() {
        BrowserUtils.waitForVisibility(name, 10);
        return name;
    }

    public WebElement getPassword() {
        BrowserUtils.waitForVisibility(password, 10);
        return password;
    }

    public WebElement getRegistrationMessage() {
        BrowserUtils.waitForVisibility(registrationMessage, 10);
        return registrationMessage;
    }
}
