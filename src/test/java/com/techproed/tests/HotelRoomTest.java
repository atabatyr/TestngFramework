package com.techproed.tests;

import com.techproed.smoketest.PositiveTest;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.dns.ResolverConfiguration;

import javax.swing.*;

public class HotelRoomTest extends TestBase {
    //Create a clickOnLogin method
    public void clickOnLogin() {
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }

    @Test
    public void createHotelRoom() throws InterruptedException {
        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        //Click on Hotel Management
        WebElement hotelManagement=driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        //Click on Hotel Rooms
        WebElement hotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
        //Click on Add Hotel Room
        WebElement addHotelRoomButton=driver.findElement(By.partialLinkText("ADD HOTELROOM"));
        addHotelRoomButton.click();
        //Enter All required fields
        WebElement idHotelDropdown=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idHotelDropdown);
        select.selectByIndex(1);

        WebElement code=driver.findElement(By.id("Code"));
        code.sendKeys("12345");

        WebElement name= driver.findElement(By.id("Name"));
        name.sendKeys("Best Hotel");

        WebElement location=driver.findElement(By.id("Location"));
        location.sendKeys("Galveston");

        WebElement description=driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        description.sendKeys("This is Royal Class Hotel Room");

        //TO enter a price, we can send keys, OR we can use actions class to drop
        WebElement source=driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement target=driver.findElement(By.id("Price"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).perform();

        WebElement roomTypeDropdown=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomTypeDropdown);
        select1.selectByVisibleText("Studio");

        WebElement maxAdultCount=driver.findElement(By.id("MaxAdultCount"));
        maxAdultCount.sendKeys("5");

        WebElement maxChildrenCount=driver.findElement(By.id("MaxChildCount"));
        maxChildrenCount.sendKeys("6");

        WebElement approvedCheckbox=driver.findElement(By.id("IsAvailable"));
        approvedCheckbox.click();


        //Click Save
        WebElement saveButton=driver.findElement(By.id("btnSubmit"));
        saveButton.click();

        //Verify the message:HotelRoom was inserted successfully
        //Explicit wait should be used, because implicit wait didn't work fine
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        String successMessageText=successMessage.getText();
        Assert.assertEquals(successMessageText,"HotelRoom was inserted successfully");
        WebElement okButton=driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        //Home WOrk1: Complete the next two step
        //Now click on HotelRooms
        //Then verify the hotelID=Star on that page
    }

    @Test
    public void roomReservation() throws InterruptedException {
        //HomeWORK2: As user I should be able to create a room reservation
        //As tester, you decide your test data.
        //Use same manager id and password
        //Login
        clickOnLogin();
        //enter username
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        //enter password
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        //click on login-submit button
        driver.findElement(By.id("btnSubmit")).click();
        //click on Hotel Management button
        driver.findElement(By.id("menuHotels")).click();
        //click on Room reservations
        driver.findElement(By.linkText("Room reservations")).click();
        //Click on Add Room Reservation
        driver.findElement(By.xpath("//a[@class='btn btn-circle btn-default']")).click();
        WebElement user=driver.findElement(By.id("IDUser"));
        Select users=new Select(user);
        users.selectByIndex(1);
        WebElement hotelRoom=driver.findElement(By.id("IDHotelRoom"));
        Select hotelRooms=new Select(hotelRoom);
        hotelRooms.selectByVisibleText("Hilton");
        driver.findElement(By.id("Price")).sendKeys("500");
        driver.findElement(By.id("DateStart")).sendKeys("02/15/2021");
        driver.findElement(By.id("DateEnd")).sendKeys("05/21/2021");
        driver.findElement(By.id("AdultAmount")).sendKeys("2");
        driver.findElement(By.id("ChildrenAmount")).sendKeys("3");
        driver.findElement(By.id("ContactNameSurname")).sendKeys("Batyr Atayev");
        driver.findElement(By.id("ContactPhone")).sendKeys("8322762654");
        driver.findElement(By.id("ContactEmail")).sendKeys("atabatyr@gmail.com");
        driver.findElement(By.id("Notes")).sendKeys("I don't like rice");
        driver.findElement(By.id("Approved")).click();
        driver.findElement(By.id("IsPaid")).click();
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(15000);
        //Verify HomerReservation is done succesfully
        String messageSuccess=driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
        Assert.assertEquals(messageSuccess,"RoomReservation was inserted successfully");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }
}
