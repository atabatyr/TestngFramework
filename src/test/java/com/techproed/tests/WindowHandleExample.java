package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    //Given user is on the https://the-internet.herokuapp.com/windows
    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        //GThen user verifies the text : "Opening a new window"
        String newWindowText=driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        String expectedNewWindowText="Opening a new window";
        Assert.assertEquals(newWindowText,expectedNewWindowText);
        //Then user verifies the title of the page is "The Internet"
        String pageTitle=driver.getTitle();
        String expectedPageTitle="The Internet";
        //Check if the expected Titile ewquals the actual Titile. IF they are not equal then print Title is incorrect
        Assert.assertEquals(pageTitle,expectedPageTitle);
        //We are getting first window handle when we need to switch.
        String window1=driver.getWindowHandle();
        System.out.println(window1);
        //Then user clicks on the "Click Here" button
        driver.findElement(By.linkText("Click Here")).click();
        // Then user verifies the new window title is "New Window"
        // The New Window opens in a new tab. This means we have to switch to the new Widnow!!!!
        //We will get all open window handle and put them in a set
        Set<String> allWindows=driver.getWindowHandles();
        //Using for each loop, we can switch to the new window.
        for (String eachWindow:allWindows){
            if (!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);
            }
        }
        String actualNewPageTitle=driver.getTitle();
        String expectedNewPageTitle="New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New Page Title is not equal");
        // Then user verifies the text: "New Window"
        String actualSecondWindowText=driver.findElement(By.xpath("//h3")).getText();
        String expectedSecondWindowText="New Window";
        Assert.assertEquals(actualSecondWindowText,expectedSecondWindowText,"New Window text is not matching");
        // When user goes back to the previous window and then verifies the title:"The Internet"
        driver.switchTo().window(window1);
        Assert.assertEquals(driver.getTitle(),"The Internet");
        //Collapse

    }



}
