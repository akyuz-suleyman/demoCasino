package com.demo_casino.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {

    /**
     * wait for an element to be clickable (with web element)
     */
    public static void waitClickability(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for an element to be clickable (with By locator)
     */
    public static void waitClickability(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for clickability of an element then click
     */
    public static void clickWithWait(WebElement element, int timeOut) {
        waitForVisibility(element, timeOut);
        waitClickability(element, timeOut);
        element.click();
    }

    /**
     * wait for visibility of a web element
     */
    public static void waitForVisibility(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait till a new window gets opened
     */
    public static void waitForNewWindow() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
This method will accept int (in seconds) and execute Thread.sleep
for given duration
*/
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    public static String getAlertMessage(){

        Alert alert=Driver.getDriver().switchTo().alert();
        String message=alert.getText();

        return message;

    }


}
