package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    //Create a clickOnLogin method
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton=driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }
    @Test
    public void positiveLoginTest() throws InterruptedException {
        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        //System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='hidden-480']")).isDisplayed());
        //Assert.assertTrue(driver.getCurrentUrl().equals("http://www.kaolapalace-qa-environment2.com/Admin/UserAdmin"));
        //Sign Out is our homework
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[@class='dropdown dropdown-user']"))).perform();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-default']")).click();
        Thread.sleep(5000);

    }

}
