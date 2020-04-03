package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.server.KnownElements;
import org.openqa.selenium.remote.server.Session;
import org.openqa.selenium.support.ui.Select;


import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pradip
 */
public class Utility {

    public WebDriver driver;
    public static String sameEmail;
    public static String samePassword;

    //this method need to use when we want to click on any elements
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //this method need to use when we want to send any data in any field
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //this method need to use when we want to compare result expected and actual result
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //this method need to use when we want to mouse hover on any element and click on that element
    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    //this method need to use when we want to mouse hover and perform on any element
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();

    }

    //this method need to use when we want to select by value from drop down elements
    public void selectByValueForDropDownElement(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    //this method need to use when we want to select by visible text from drop down elements
    public void selectByVisibleTextForDropDownElement(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    //this method need to use when we want to select by index from drop down elements
    public void selectByIndexForDropDownElement(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    //this method need to use when we want to create random email and register in demo site
    public void enterRandomEmail(By by) {
        Random anyEmail = new Random();
        int randomInt = anyEmail.nextInt(1000);
        sameEmail = "DhannoBhag" + randomInt + "@gmail.com";
        driver.findElement(by).sendKeys(sameEmail);


    }

    //this method we need to use when we want to use stored email id like above email stored
    public void enterStoredEmailToNextField(By by, String str) {
        str = sameEmail;
        driver.findElement(by).sendKeys(str);

    }

    //this method we need to use when we want to enter random password many time
    public void enterRandomPassword(By by) {
        Random anyPassword = new Random();
        int randomInt = anyPassword.nextInt(1000);
        samePassword = "DhannoBhag" + randomInt;
        driver.findElement(by).sendKeys(samePassword);
    }

    //this method we need to use to enter stored password like above password
    public void enterStoredPasswordToNextField(By by, String pass) {
        pass = samePassword;
        driver.findElement(by).sendKeys(pass);

    }


}



