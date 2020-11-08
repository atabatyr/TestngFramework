package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {
    @Test
    public void logInTest() throws InterruptedException {
        //Go to Webpage
        driver.get("https://www.facebook.com/");
        //Create FaceLoginPage Object
        FaceLoginPage faceLoginPage=new FaceLoginPage(driver);
        //send username
        faceLoginPage.username.sendKeys("asdfadfsafsafsafasdf");
        //send password
        faceLoginPage.password.sendKeys("adfasdfsdfsdfsadfdsaf");
        //click on login button
        faceLoginPage.login.click();
        Thread.sleep(6000);
        //Assert errorMessage
        String actualErrorMessage=faceLoginPage.errorMessage.getText();
        String expectedErrorMessage="The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


    }
}
