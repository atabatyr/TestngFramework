package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass3 extends TestBase {

    //Create a class: ActionsClass3
    //Create a test method: keysUpDown()

    @Test
    public void keysUpDown() throws InterruptedException {
        // Go to google
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        // send iPhone X prices => convert small letter capital vice versa.
        Actions actions=new Actions(driver);
        actions.
                keyDown(searchBox, Keys.SHIFT)//Pressing shift on the search box element
                .sendKeys("iPhone X prices") // typing in the box
                .keyUp(searchBox,Keys.SHIFT)//We have to unpress from the shift button
                .perform();//performing the action
        //Highlight the search box by double clicking
        actions.doubleClick(searchBox).perform();
        Thread.sleep(5000);
    }
    @Test
    public void keysUpDown1() throws InterruptedException {
        // Go to google
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        // send iPhone X prices => convert small letter capital vice versa.
        Actions actions=new Actions(driver);
        actions.
                keyDown(searchBox, Keys.SHIFT)//Pressing shift on the search box element
                .sendKeys("iPhone X prices") // typing in the box
                .keyUp(searchBox,Keys.SHIFT)//We have to unpress from the shift button
                .sendKeys(" android prices")
                .perform();//performing the action
        //Highlight the search box by double clicking
        actions.doubleClick(searchBox).perform();
        Thread.sleep(5000);
    }

}
