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

public class AmazonHomework {
    //Use Different Test Method for each Test Case
    //Go to https://www.amazon.com

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    //Find the element of the dropdown element. HINT :By.id("searchDropdownBox")
    //Print the first selected option and assert if it equals "All Departments"
    @Test
    public void test1(){
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDown);
        String actualFirstSelectedOptionText=options.getFirstSelectedOption().getText();
        System.out.println(actualFirstSelectedOptionText);
        Assert.assertEquals(actualFirstSelectedOptionText,"All Departments");
    }
    // SElect the 4th option by index (index of 3) and assert if the name is "Amazon Devices". ( after you select you need to use get firm option method)
    @Test
    public void test2(){
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDown);
        options.selectByIndex(3);
        String actualSelectedOption=options.getFirstSelectedOption().getText();
        System.out.print(actualSelectedOption);

    }
    // Print all of the dropdown options
    @Test
    public void printAllOptions() throws InterruptedException {
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDown);
        List<WebElement> allOptions=options.getOptions();
        for(WebElement w: allOptions){
            System.out.println(w.getText());
        }
    }
    //Print the total number of options in the dropdown
    @Test
    public void totalNumberOption(){
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDown);
        List<WebElement> allOptions=options.getOptions();
        System.out.println("Total number of Options is "+allOptions.size());
    }

    // BONUS: Check if Appliances is a drop down option. Print true if "Appliances" is an option. Print false otherwise
    @Test
    public void appliances(){
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDown);
        List<WebElement> allOptions=options.getOptions();
        int i=0;
        for(WebElement w: allOptions){
            if(w.getText().equals("Appliances")){
                i=i+1;
            }
        }
        if(i!=0){
            System.out.print("True");
        }
        else{
            System.out.println("False");
        }
    }

    //BONUS: Check if the dropdown is in Alphabetical Order.
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
