package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass1 extends TestBase {

    @Test
    public void contextClickMethod() throws InterruptedException {
        //contextClick = right click
        //Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //When use Right clicks on the box
        Actions actions=new Actions(driver);
        //Locate the box
        WebElement box=driver.findElement(By.id("hot-spot"));
        Thread.sleep(5000);
        //Don't forget to use perform
        actions.contextClick(box).perform();
        // Then verify the alert message is "You selected a context menu"
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        //then accept the alert
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }
}
