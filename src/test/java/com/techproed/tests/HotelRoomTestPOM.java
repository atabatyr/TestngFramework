package com.techproed.tests;

import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.KaolaDefaultPage;
import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelRoomTestPOM extends TestBase {

    public void kaolaLogin() {
        driver.get(ConfigReader.getProperty("koala_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage(driver);
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(driver);
        kaolaLoginPage.kaolaUserName.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
    }
    @Test
    public void hotelRoomTest() throws InterruptedException {
        kaolaLogin();
        KaolaDefaultPage kaolaDefaultPage=new KaolaDefaultPage(driver);
        kaolaDefaultPage.hotelManagement.click();
        kaolaDefaultPage.hotelRooms.click();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage(driver);
        hotelRoomsPage.addHotelRoomButton.click();
        Select select=new Select(hotelRoomsPage.idHotelDropdown);
        select.selectByIndex(1);
        hotelRoomsPage.code.sendKeys("Ata123!");
        hotelRoomsPage.name.sendKeys("Houston Hotel");
        hotelRoomsPage.location.sendKeys("Houston");
        hotelRoomsPage.description.sendKeys("This is the best hotel in Houston Area");
        Actions actions=new Actions(driver);
        actions.dragAndDrop(hotelRoomsPage.priceSource,hotelRoomsPage.price).perform();
        Select selectedRoomType=new Select(hotelRoomsPage.roomTypeDropdown);
        selectedRoomType.selectByVisibleText("King");
        hotelRoomsPage.maxAdultCount.sendKeys("2");
        hotelRoomsPage.maxChildCount.sendKeys("3");

        Thread.sleep(5000);



    }
}
