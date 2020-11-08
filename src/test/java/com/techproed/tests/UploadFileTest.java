package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends TestBase {

    @Test
    public void uploadFileMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //locate the element of choosefile
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        //We need to send the path of the image
        //Each of your path wiill be different
        //Find your own path
        String pathOfTheFile = "C:\\Users\\atab\\Pictures\\dom.png";
        //We will send this pathOfTheFile to the chooseFile button
        chooseFile.sendKeys(pathOfTheFile);
        Thread.sleep(5000);
        //Click on upload button
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(5000);
        //Verify "File Uploaded!" message
        String actualHeadMessage=driver.findElement(By.tagName("h3")).getText();
        String expectedHeadMessage="File Uploaded!";
        Assert.assertEquals(actualHeadMessage,expectedHeadMessage,"File is not uploaded properly");
        Thread.sleep(5000);


    }
}
