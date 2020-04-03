package testcase;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;




/*
Create Java Project Name "xcart-demo-store"

baseURL: https://demostore.x-cart.com/

1.Create Two Package name "utility" and "testcase"
2.In utility package create one class name Utility and copy paste all your methods in to this utility class.
3.In testcase package create one class name TestCase.
4.In TestCase class create test methods.
	1. userShouldCreateNewAccount
		Click on "Sign in/ sign up"
		Click on "Create new account" Link
		Enter Email
		Enter password
		Enter Confirm password
		Click on create button
		Verify text "My account"
		Click on "My account" Link on right-hand side corner
		Click on "Log out" tab
		Verify "Sign in/ sign up" tab

	2. userShouldLoginSuccessfully
		Click on "Sign in/ sign up"
		Enter Email (Same email address that created in first test)
		Enter password ( Same password as created in first test)
		Click on Sign in button
		Verify text "My account"
		Click on "My account" Link on right-hand side corner
		Click on "Log out" tab
		Verify "Sign in/ sign up" tab

 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

/**
 * Created by Pradip
 */
public class TestCase extends Utility {
    String baseUrl = "https://demostore.x-cart.com/";

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @Test
    public void userShouldCreateNewAccount() {
        clickOnElement(By.xpath("//div[@class='header_bar-sign_in']//span[contains(text(),'Sign in / sign up')]"));
        clickOnElement(By.xpath("//a[@class='popup-button default-popup-button create-account-link']"));
        //random method to enter any email address
        enterRandomEmail(By.xpath("//input[@id='login']"));
        //random method to enter any password
        enterRandomPassword(By.xpath("//input[@id='password']"));
        //stored password in random method and entered store password in below line
        enterStoredPasswordToNextField(By.xpath("//input[@id='password-conf']"), "pass");
        clickOnElement(By.xpath("//div[@class='button submit']"));

        String expectedResult = "My account";
        String actualResult = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedResult, actualResult);

        mouseHoverAndClick(By.xpath("//div[@class='dropdown header_bar-my_account']"));
        mouseHoverAndClick(By.xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));
        clickOnElement(By.xpath("//div[@class='header_bar-sign_in']//span[contains(text(),'Sign in / sign up')]"));

        String expectedResult1 = "Sign in / sign up";
        String actualResult1 = getTextFromElement(By.xpath("//div[@class='header_bar-sign_in']//span[contains(text(),'Sign in / sign up')]"));
        Assert.assertEquals(expectedResult1, actualResult1);

    }

    @Test
    public void userShouldLoginSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@class='header_bar-sign_in']//span[contains(text(),'Sign in / sign up')]"));
        //stored above test email in random method and entered store email in below line
        enterStoredEmailToNextField(By.xpath("//input[@id='login-email']"), "str" + sameEmail);
        //stored password in random method and entered store password in below line
        enterStoredPasswordToNextField(By.xpath("//input[@id='login-password']"), "pass");
        clickOnElement(By.xpath("//button[contains(@class,'submit')]//span[contains(text(),'Sign in')]"));

        String expectedResult = "My account";
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"dropdown header_bar-my_account\"]"));
        Assert.assertEquals(expectedResult, actualResult);

        mouseHoverAndClick(By.xpath("//a[contains(text(),'My account')]"));
        mouseHoverAndClick(By.xpath("//ul[@class='account-links dropdown-menu']//span[contains(text(),'Log out')]"));

        String expectedResult1 = "Sign in / sign up";
        String actualResult1 = getTextFromElement(By.xpath("//div[@class='header_bar-sign_in']//span[contains(text(),'Sign in / sign up')]"));
        Assert.assertEquals(expectedResult1, actualResult1);


    }

    @After
    public void closeBrowser() {
        // driver.quit();
    }

}
