package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    //Go to https://the-internet.herokuapp.com/javascript_alerts
    //Create setUp method
    //Create 3 test methods

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    // acceptAlert() => click on the first alert, verify the text "I am a JS Alert", click OK, and verify "You successfully clicked"
    @Test
    public void acceptAlert() throws InterruptedException {
        WebElement firstButton=driver.findElement(By.xpath("(//button)[1]"));
        //clicking on the first alert button
        firstButton.click();
        //Getting text on the alert
        String firstAlertText=driver.switchTo().alert().getText();
        //Verifying if the text is equal ot "I am a JS Alert"
        Assert.assertEquals(firstAlertText,"I am a JS Alert");
        Thread.sleep(3000);
        //Clicking OK by using alert accept() method
        driver.switchTo().alert().accept();
        //Getting the text of element
        String expectedResult="You successfuly clicked an alert";
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void dismissAlert() throws InterruptedException {
        // dismissAlert()=> click on the second alert, verify text "I am a JS Confirm", click cancel, and Verify "You clicked: Cancel"
        WebElement secondButton=driver.findElement(By.xpath("(//button)[2]"));
        Thread.sleep(3000);
        secondButton.click();
        // I am getting the text on the second alert
        String actualAlertText=driver.switchTo().alert().getText();
        //Asserting if the expected text equals actual text
        Assert.assertEquals(actualAlertText,"I am a JS Confirm");
        //Clicking on Cancel button on the alert
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //Asserting the expected result text and actual result text are equal or not
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,"You clicked: Cancel");
    }

    // send KeysAlert()=> click on the third alert, verify text "I am a JS prompt", type "Hello World", click OK, and Verify "You enter: Hello World"
    @Test
    public void sendKeysAlert() throws InterruptedException {
     WebElement thirdButton=driver.findElement(By.xpath("(//button)[3]"));
     Thread.sleep(3000);
     thirdButton.click();
     //Switching the third alert
     String actualAlertText=driver.switchTo().alert().getText();
     Assert.assertEquals(actualAlertText,"I am a JS prompt");
     Thread.sleep(3000);
     driver.switchTo().alert().sendKeys("Hello World");
     Thread.sleep(3000);
     //clicking OK button
     driver.switchTo().alert().accept();
     //Asserting if the actual result and expected result eqaul
     String actualResult=driver.findElement(By.id("result")).getText();
     Assert.assertEquals(actualResult,"You entered: Hello World");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
