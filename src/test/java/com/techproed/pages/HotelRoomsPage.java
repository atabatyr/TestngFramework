package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {
    WebDriver driver;
    public HotelRoomsPage(WebDriver driver){
        this.driver= (WebDriver) driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoomButton;

    @FindBy(id="IDHotel")
    public WebElement idHotelDropdown;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id="Name")
    public WebElement name;

    @FindBy(id="Location")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement description;

    @FindBy(id="Price")
    public WebElement price;

    @FindBy(xpath = "//li[@data-id='700']")
    public  WebElement priceSource;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id="MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id="MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(id = "uniform-IsAvailable")
    public WebElement approvedCheckBox;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    /*


     */
}
