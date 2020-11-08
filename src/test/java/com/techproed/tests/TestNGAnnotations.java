package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    //1. Create a method: setUp using @BeforeMethod
    // annotation and print "This is BeforeMethod"
    @BeforeMethod
    public void setUp() {
        System.out.println("This is BeforeMethod");
    }

    //2. Create a method : tearDown using @AfterMethod
    // annotation and print "This is @AfterMethod"
    @AfterMethod
    public void tearDown() {
        System.out.println("This is @AfterMethod");
    }

    //3 Create 4 Test Methods: test1, test2, test3, test4 and print "Test1", "Test2","Test3", "Test4"
    //4. Skip test2
    //5. print the test in this order: Test3, Test4, Test1
    @Test(priority = 3)
    public void test1() {
        System.out.println("Test1");
    }

    @Ignore
    @Test
    public void test2() {
        System.out.println("Test2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("Test3");
    }

    @Test(priority = 2)
    public void test4() {
        System.out.println("Test4");
    }


}
