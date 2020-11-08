package com.techproed.tests;

import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class FirstDriverTest {
    @Test
    public void firstDriverTest() throws InterruptedException {
        //When user goes to the applications http://www.kaolapalace-qa-environment2.com/
        //And click on the Login button
        //Then verify user is able to log in
        //driver=====>>>>>>>>Driver.getDriver();
        Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("koala_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage(Driver.getDriver());
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(Driver.getDriver());
        kaolaLoginPage.kaolaUserName.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
        Thread.sleep(5000);
        Driver.closeDriver();

    }
}
