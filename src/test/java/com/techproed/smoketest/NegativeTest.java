package com.techproed.smoketest;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest {
    //Create 3 test methods:
    //invalidPassword()
    //invalidID()
    //invalidIDAndPassword()

    //Go to: http://www.kaolapalace-qa-environment2.com/
    //Test Id:manager2

    //Create a clickOnLogin method
    public void clickOnLogin(){
        Driver.getDriver().get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton=Driver.getDriver().findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }
    @Test(groups = "regression1")
    public void invalidPassword() {
        //USER STORY NAME: User should not be able to log in with incorrect password

        //ACCEPTANCE CRITERIA:
        //invalidPassword():
        //When user goes to the appliaction http://www.kaolapalace-qa-environment2.com/
        //Click on the Login button
        //And verify user is not able to login with incorrect password

        clickOnLogin();
        WebElement username=Driver.getDriver().findElement(By.id("UserName"));
        WebElement password=Driver.getDriver().findElement(By.id("Password"));
        username.sendKeys("manager2");
        password.sendKeys("1234");
        WebElement loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        loginButton.click();
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Wrong password"));

        //Sprint 10
        //us1234=> removing a user story in the middle of the sprint means BAD SPRINT PLANNING
        //if you can't finish then it should be done in the upcoming sprint,. AGAIN THIS SHOULD BARELY HAPPEN


    }

    @Test
    public void invalidID(){
        //USER STORY NAME: User should not be able to log in with incorrect username

        //ACCEPTANCE CRITERIA:
        //invalidID():
        //When user goes to the appliaction http://www.kaolapalace-qa-environment2.com/
        //Click on the Login button
        //And verify user is not able to login with incorrect ID when the username is correct
        clickOnLogin();
        WebElement username=Driver.getDriver().findElement(By.id("UserName"));
        WebElement password=Driver.getDriver().findElement(By.id("Password"));
        username.sendKeys("fakeid");
        password.sendKeys("Man1ager2!");
        WebElement loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        loginButton.click();
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        Assert.assertTrue(errorMessageText.contains("Username or password is incorrect, please correct them and try again"));

    }

    @Test(groups = "regression1")
    public void invalidIDAndPassword(){
        //USER STORY NAME: User should not be able to log in with incorrect username or password

        //ACCEPTANCE CRITERIA:
        //invalidIDAndPassword():
        //When user goes to the appliaction http://www.kaolapalace-qa-environment2.com/
        //Click on the Login button
        //And verify user is not able to login with incorrect ID or password
        clickOnLogin();
        WebElement username=Driver.getDriver().findElement(By.id("UserName"));
        WebElement password=Driver.getDriver().findElement(By.id("Password"));
        username.sendKeys("fakeid");
        password.sendKeys("Man1ager2!");
        WebElement loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        loginButton.click();
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        Assert.assertTrue(errorMessageText.contains("Try again please"));

    }

}
