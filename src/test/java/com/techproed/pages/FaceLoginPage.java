package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Class
// THIS CLASS WILL ONLY HAVE PAGE OBJECTS / PAGE ELEMENTS
public class FaceLoginPage {
    WebDriver driver;

    //Create a constructor to initialize the driver
    public FaceLoginPage(WebDriver driver){
        this.driver=driver;
        //initElements method initialized the driver in page object model
        PageFactory.initElements(driver,this);
        //We use initElements to initialize the driver in the constructor
    }
    @FindBy(id="email")
    public WebElement username;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(xpath="//button[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement errorMessage;


}
