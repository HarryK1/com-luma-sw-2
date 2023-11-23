package testsuite;
/*
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
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

public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //click on 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //enter valid email
        driver.findElement(By.id("email")).sendKeys("juneab1213@gmail.com");
        //enter valid password
        driver.findElement(By.id("pass")).sendKeys("Prim#43240");
        //click on sign in button
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        //driver.findElement(By.linkText("Sign In")).click();
        //verify the welcome text is displayed
        String expectedText = "Welcome, Steve Moody!";
        //String actualText = driver.findElement(By.tagName("/span")).getText();
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Steve Moody!']")).getText();
        //String actualText = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        //...tagName/span...xpath(//span[@class='logged-in'])[1]
        Assert.assertEquals(expectedText, actualText);
    }

    @Test

    public void verifyTheErrorMessageWithInvalidCredentials(){
        //click on 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //enter email
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        //enter password
        driver.findElement(By.id("pass")).sendKeys("Prime123");
        //click on sign in button
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        //driver.findElement(By.linkText("Sign In")).click();
        //Verify the error message ‘The account sign-in was
        //incorrect or your account is disabled temporarily. Please wait and try again
        //later.’
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error error message']")).getText();
        //tagName../div...linkText..The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
        //xpath//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage);
    }

    @Test

    public void userShouldLogOutSuccessfully(){
        //click on 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //enter valid email
        driver.findElement(By.id("email")).sendKeys("juneab1213@gmail.com");
        //enter valid password
        driver.findElement(By.id("pass")).sendKeys("Prim#43240");
        //click on sign in button
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        //driver.findElement(By.linkText("Sign In")).click();
        //verify the welcome text is displayed
        String expectedText = "Welcome, Steve Moody!";
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Steve Moody!']")).getText();
        //...tagName/span...xpath(//span[@class='logged-in'])[1]
        Assert.assertEquals(expectedText, actualText);
        //click on down arrow near welcome
        driver.findElement(By.xpath("(//button[contains(@class,'action switch')])[1]")).click();
        //click on sign out link
        //driver.findElement(By.linkText("Sign Out")).click();
        driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
        //Verify the text ‘You are signed out'
        String expectedDisplay = "You are signed out";
        String actualDisplay = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals("you are signed out", expectedDisplay, actualDisplay);
    }

    @After

    public void tearDown(){
        closeBrowser();
    }

}
