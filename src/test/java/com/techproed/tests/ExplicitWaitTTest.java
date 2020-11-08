package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ExplicitWaitTTest extends TestBase {
    //Create a class: ExplicitWaitTest. Create a method: explicitWait
    @Test
    public void explicitWait() throws InterruptedException {
        //CREATE WAIT OBJECT
        WebDriverWait wait=new WebDriverWait(driver,10);

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click on remove button
        WebElement button=driver.findElement(By.xpath("//form[@id='checkbox-example']//button"));
        button.click();
        //And verify the message is equal to "It's gone!"


        //This is where I need to wait
        //What is our expected condition??
        //Expected condition is to wait for the It's gone element
        WebElement goneMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//p")));
        //WebElement goneMessage=driver.findElement(By.xpath("//form[@id='checkbox-example']//p"));


        String goneMessageText=goneMessage.getText();
        Assert.assertEquals(goneMessageText,"It's gone!");
        // Then click on Add button
        WebElement addButton=driver.findElement(By.xpath("//form[@id='checkbox-example']//button"));
        addButton.click();
        //And verify the message is equal to "It's back!"


        WebElement backMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//p")));
        //WebElement backMessage=driver.findElement(By.xpath("//form[@id='checkbox-example']//p"));
        Thread.sleep(10000);
        Assert.assertEquals(backMessage.getText(),"It's back!");
        //WebElement actualTextElement2=driver.findElement(By.xpath("//form[@id='checkbox-example']//p"));


    }
}
