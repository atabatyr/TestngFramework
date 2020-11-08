package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void logIn(){
        System.out.println("Log in TEST");
    }

    @Test
    public void homePage(){
        System.out.println("Home Page TEST");
        Assert.assertEquals(3,5);
    }

    @Test(dependsOnMethods = "homePage")
    public void searchTest(){
        // I want searchTest to be dependent on homepage. I want searchTest skipped if homepage fails
        System.out.println("Search TEST");
    }

    @Test
    public void verifyResults(){
        System.out.println("Result TEST");
    }

}
