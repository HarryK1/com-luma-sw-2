package testsuite;
/*
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down arrow near Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before

    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){
        //click on create account link
        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();
        //verify the text Create New Custom Account
        String expectedDisplay = "Create New Customer Account";
        String actualDisplay = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("No Display", expectedDisplay, actualDisplay);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on create an account link
        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();
        //enter first name
        driver.findElement(By.id("firstname")).sendKeys("Steve");
        //enter last name
        driver.findElement(By.id("lastname")).sendKeys("Moody");
        //click on checkbox Sign Up for Newsletter
        //no checkbox on the page
        //enter Email
        driver.findElement(By.id("email_address")).sendKeys("juneab1213@gmail.com");
        //enter password
        driver.findElement(By.id("password")).sendKeys("Prim#43240");
        //enter confirm password
        driver.findElement(By.id("password-confirmation")).sendKeys("Prim#43240");
        //click on create an account button
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        //verify Thank you for registering with Main Website Store
        String expectedText = "Thank you for registering with Main Website Store.";
        //String actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
        Assert.assertEquals(expectedText, actualText);

        //click on down arrow near welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        //click on sign out link
        driver.findElement(By.linkText("Sign Out")).click();
        //driver.findElement(By.tagName("/a")).click();
        //Verify the text ‘You are signed out'
        String expectedDisplay = "You are signed out";
        String actualDisplay = driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
        Assert.assertEquals("you are signed out", expectedDisplay, actualDisplay);
    }

    @After

    public void tearDown(){
        closeBrowser();
    }
}

