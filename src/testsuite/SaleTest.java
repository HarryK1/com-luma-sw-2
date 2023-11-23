package testsuite;
/*
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //click on sale menu tab
        //xpath//a[@id='ui-id-8']..
        driver.findElement(By.id("ui-id-8")).click();
        //click on Jackets link on the left side under Women's Deal Category
        //xpath//a[contains(text(),'Jackets')]
        driver.findElement(By.linkText("Jackets")).click();
        //verify that text Jackets is displayed
        String expectedDisplay = "Jackets";
        String actualDisplay = driver.findElement(By.id("page-title-heading")).getText();
        //xpath//span[@data-ui-id='page-title-wrapper'] or //span[@class='base']
        Assert.assertEquals("Jackets not found", expectedDisplay, actualDisplay);

        // count the total items displayed on page and print the name of all items

        List<WebElement> item = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Total item : " + item.size());
        System.out.println("-----------------");

        for(WebElement e : item){
            System.out.println(e.getText());
            }
        }
    }


