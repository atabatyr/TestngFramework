package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

//Create a class :FileDownload
    //downloadTest()
public class FileDownload extends TestBase {

    @Test
    public void downloadTest() throws InterruptedException {
        //In the downloadTest() method, do the following test:
        //Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //Download flower.jpg file
        WebElement flower=driver.findElement(By.linkText("logo.png"));
        flower.click();
        //We must put some waiting time for downloading to complete
        Thread.sleep(5000);
        //We can find the user folder using System.getProperty()-home folder;
        String userFolder=System.getProperty("user.home");
        System.out.println(userFolder);
        //Path of the file
        String pathOfTheFile=userFolder+"\\Downloads\\logo.png";
        //String pathOfTheFile="C:\\Users\\atab\\Downloads\\Lighthouse.jpg";
        //Boolean isDownloaded=file.exists(Paths.get(file path));
        boolean isDownloaded= Files.exists(Paths.get(pathOfTheFile));
        //Then verify if the file downloaded successfully
        //Use assertion to check if boolean is true or false
        Assert.assertTrue(isDownloaded);

    }

}
