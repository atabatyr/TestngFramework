package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsClass4 extends TestBase {

    //Create test method : scrollUpDown()
    @Test
    public void scrollUpDown() throws InterruptedException {
        //Go to amazon
        driver.get("https://www.amazon.com");
        // Scroll the page down
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();// Arrow_Down moved the page down, but it moves less than Page_Down
        Thread.sleep(5000);

        //Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(5000);//Arrow_Up will also move the page up but a little bit up.

        //When do we move the page up or page down in testing?
        //Some pages are long. When we need to take a screenshot of an element that is at the buttom of the page,
        //We have to move the page down.



    }

}
