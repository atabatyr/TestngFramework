package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void hardAssertTest(){
        WebElement gmailLink=driver.findElement(By.linkText("Gmail"));
        // Assert if the gmail link text is "gmail" or not
        String expectedGmailText="Gmail";
        String actualGmailText=gmailLink.getText();
        Assert.assertEquals(actualGmailText,expectedGmailText);

        WebElement imagesLink=driver.findElement(By.linkText("Images"));
        //Assert if the images link text is equal to "Images"
        String actualImageLinkText=imagesLink.getText();
        String expectedImageLinkText="Images";
        Assert.assertEquals(actualImageLinkText,expectedImageLinkText);

        WebElement signInLink=driver.findElement(By.linkText("Sign in"));
        //Assert if the sign in lin text "sign in"
        String expectedSignInLinkText="sign in";
        String actualSignInLinkText=signInLink.getText();
        Assert.assertEquals(actualSignInLinkText,expectedSignInLinkText);//FAIL
    }

    @Test
    public void softAssertTest(){
        WebElement gmailLink=driver.findElement(By.linkText("Gmail"));
        // Assert if the gmail link text is "gmail" or not
       String expectedGmailText="gmail";
       String actualGmailText=gmailLink.getText();
       SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals(actualGmailText,expectedGmailText);//FAIL


       WebElement imagesLink=driver.findElement(By.linkText("Images"));
       //Assert if the images link text is equal to "Images"
       String expectedImageLinkText="Images";
       String actualImageLinkText=imagesLink.getText();
       softAssert.assertEquals(actualImageLinkText,expectedImageLinkText);//PASS


       WebElement signInLink=driver.findElement(By.linkText("Sign in"));
       //Assert if the sign in lin text "sign in"
       String actualSignInLinkText=signInLink.getText();
       String expectedSignInLinkText="sign in";
       softAssert.assertEquals(actualSignInLinkText,expectedSignInLinkText);//FAIL

       // When we use soft assert, we have to use assertAll() to get the actual reports.
       //Without assertAll, this is not correct test case
       softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
