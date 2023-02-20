package com.demo_casino.pages;

import com.demo_casino.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    public WebElement getLoginButton() {
        BrowserUtils.waitClickability(loginButton, 10);
        return loginButton;
    }

}
