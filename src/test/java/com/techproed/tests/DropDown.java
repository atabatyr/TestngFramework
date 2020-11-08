package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

    WebDriver driver;

// Go to https://the-internet.herokuapp.com/dropdown
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest() throws InterruptedException {

        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select options=new Select(dropDown);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //1. Select and Print option 1 using index
        Thread.sleep(3000);
        options.selectByIndex(1);
        //Step3 Select the option byIndex or byValue, or byVisibleText



    }
    //setUp=>dropDwon =>setUP=>selectByValue
    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select options=new Select(dropDown);
        Thread.sleep(3000);
        //2. Select and print option 2 by value
        options.selectByValue("2");
    }


    //3 Select and print Option1 by visible text
    @Test
    public void selectByVisibleText() throws InterruptedException {
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select options=new Select(dropDown);
        Thread.sleep(3000);
        options.selectByVisibleText("Option 1");
    }
    //4. Print all dropdown values
    @Test
    public void printAllValues() throws InterruptedException {
       WebElement dropDown=driver.findElement(By.id("dropdown"));
       Select options=new Select(dropDown);
       Thread.sleep(3000);
       List<WebElement> allOptions = options.getOptions(); // This gives ALL OFF THE DROPDOWN OPTIONS
        for(WebElement w:allOptions){
            System.out.println(w.getText());
        }
    }

    //5. Find the size of the dropdown, Print true if there are 4 elements in the dropdown
    @Test
    public void dropDownSizeTest() throws InterruptedException {
        WebElement dropDownElement=driver.findElement(By.id("dropdown"));
        Select options=new Select(dropDownElement);
        Thread.sleep(3000);
        int actualSizeOfDropdown=options.getOptions().size();
        Assert.assertEquals(actualSizeOfDropdown,4,"Expected is not equal to actual");
    }

    @Test
    public void getSelectedOptionTest() throws InterruptedException {
        WebElement dropDownElement=driver.findElement(By.id("dropdown"));
        Select options=new Select(dropDownElement);
        Thread.sleep(3000);
        String firstSelectedOption = options.getFirstSelectedOption().getText();
        System.out.println("First Selected Option "+firstSelectedOption);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
