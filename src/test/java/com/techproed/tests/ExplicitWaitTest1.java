package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest1 extends TestBase{
    //Create a class: ExplicitWaitTest1. Create a method: isEnabled
    @Test
    public void isEnabled(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click enable Button
        WebElement enableButton=driver.findElement(By.xpath("//form[@id='input-example']//button"));
        enableButton.click();
        //And verify the message is equal to "It's enabled!"
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(message.getText(),"It's enabled!");
        //And verify the textbox is enabled (I can type in the box)
        //Hind: isEnabled(); Similar to isDisplayed();
        WebElement inputBox=driver.findElement(By.xpath("//form[@id='input-example']//input"));
        Assert.assertTrue(inputBox.isEnabled());// IsEnable is used to understand if an element is enabled
        //And click on Disable button
        enableButton=driver.findElement(By.xpath("//form[@id='input-example']//button"));
       enableButton.click();
        //And verify the message is equal to "It's disabled!"
        message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(message.getText(),"It's disabled!");
        //And verify the textbox is disabled (I cannot type in the box);
        inputBox=driver.findElement(By.xpath("//form[@id='input-example']//input"));
        Assert.assertTrue(!inputBox.isEnabled());

    }

}
