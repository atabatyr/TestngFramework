package com.techproed.smoketest;


import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KaolaLogin extends TestBase {
    @Test
    public void kaolaLogin() throws InterruptedException {
        //driver.get("http://www.kaolapalace-qa-environment2.com/");
        driver.get(ConfigReader.getProperty("koala_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage(driver);
        kaolaMainPage.kaolaMainLoginButton.click();

        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(driver);
        //kaolaLoginPage.kaolaUserName.sendKeys(ConfigReader.getProperty("manager2"));
        kaolaLoginPage.kaolaUserName.sendKeys(ConfigReader.getProperty("username"));
        //kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("Man1ager2!"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
        Thread.sleep(5000);
    }

}
