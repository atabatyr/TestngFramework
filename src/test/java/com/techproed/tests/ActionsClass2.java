package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
//Create a class:ActionsClass2
public class ActionsClass2 extends TestBase {
    //Create test method: hoverOver() and test the following scenario:
    @Test
    public void hoverOver() throws InterruptedException {
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //When use click on "Your Account" link
        //We have to hover over to see Your Account
        WebElement hoverOverElement=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        //We use moveTOeElement to hover over on an element
        actions.moveToElement(hoverOverElement).perform();
        Thread.sleep(3000);
        //Then verify the page title contains "Your Account"
        WebElement account=driver.findElement(By.linkText("Your Account"));
        account.click();
        String actualPageTitle=driver.getTitle();
        String expectedPageTitle="Your Account";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));

    }

    @Test
    public void imageTest() throws InterruptedException {
        //Create another method : imageTest()
        driver.get("https://www.amazon.com");
        //Hover over the Try Prime
        WebElement primeLink=driver.findElement(By.id("nav-link-prime"));
        Actions actions=new Actions(driver);
        actions.moveToElement(primeLink).perform();
        Thread.sleep(5000);
        //And verify the image displays
        WebElement primeImage=driver.findElement(By.id("nav-flyout-prime"));
        Assert.assertTrue(primeImage.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void changeLanguage() throws InterruptedException {
        //Create another method: changeLanguage()
        driver.get("https://www.amazon.com");
        //Hover over the flag icon
        WebElement languageIcon=driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(languageIcon).perform();
        //and change the language
        driver.findElement(By.linkText("Español - ES")).click();
        Thread.sleep(10000);
    }

}
