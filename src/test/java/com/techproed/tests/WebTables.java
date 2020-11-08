package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {

    //Create a class :WebTables

    //PRE CONDITION. THIS IS NOT A TEST CASE
    public void login() {
        //Create a method : login()
        //Log in http://www.kaolapalace-qa-environment2.com/
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        //Click on Hotel Management
        driver.findElement(By.id("menuHotels")).click();
        //Click on Hotel Rooms
        driver.findElement(By.linkText("Hotel Rooms")).click();
    }
    @Test
    public void entireTable() throws InterruptedException {
        //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
        login();
        //Print Entire table body
        Thread.sleep(5000);
        WebElement  tBody=driver.findElement(By.xpath("//tbody"));
        System.out.print(tBody.getText());



        //Find the size of the tBody
        List<WebElement> tableData=driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println("There are "+tableData.size()+" data");
        //Another way of printing the entire table data
        for (WebElement eachData:tableData){
            System.out.println(eachData.getText());
        }
        //What is difference for each and tBody.getText()
        //Answer: In for each, i get each data one by one and print them one by one.
        //tBody gives me one SINGLE element that has ALL OF THE DAYA AS A WHOLE

        //print all of the headers
        List<WebElement> allHeaders=driver.findElements(By.xpath("//thead//tr[1]//th"));
        for (WebElement eachHeader:allHeaders){
            System.out.println(eachHeader.getText()+"  ");
        }
    }
    //Create a test method: printRows() and Print all of the rows in the table body
    @Test
    public void printRows() {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement eachRow : allRows) {
            System.out.println(eachRow.getText());
        }

        //and print the elements on the 4th row
        WebElement forthRow = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forthRow.getText());

        //OR
        System.out.println(allRows.get(3).getText());

    }



    //Create a test method: printCells() and Find the total number of cells in the table body
    // and print all of the cells
    @Test
    public void printCells(){

        login();
        List<WebElement> allCells=driver.findElements(By.xpath("//tbody//tr//td"));

        for (WebElement eachCell:allCells){
            System.out.println(eachCell.getText());
        }
        //size
        System.out.println("There are "+allCells.size()+" datas=cells");

    }


    //Create a test method : printColumns()
    @Test
    public void printColumns() throws InterruptedException {
        login();
        //and print Find the total number of columns
        List <WebElement> allColumns=driver.findElements(By.xpath("//thead//th"));
        System.out.println(allColumns.size());
        // and Print the elements of the 5th column
        Thread.sleep(5000);

        //     //tr//td[5] => give me 5th elements on each row
        List<WebElement> fifthColumn=driver.findElements(By.xpath("//td[5]"));
        for (WebElement eachElement:fifthColumn){
            System.out.println(eachElement.getText());
        }

    }

    public void printData(int row, int column){
        //Create a test method: printData(int row, int column);
        // This method should print the given cell Example:
        //printData(2,3); should print 2nd row, 3rd column

        //This custom method will take a row, and a column number
        //and print the data on that row and column
       System.out.print(driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]")).getText());
    }

    @Test
    public void printDataTest(){
        //Create a test method: printData(int row, int column);
        // This method should print the given cell Example:
        //printData(2,3); should print 2nd row, 3rd column

        //This custom method will take a row, and a column number
        //and print the data on that row and column
        login();
        printData(4,3);
        printData(2,3);
        printData(5,4);
    }



    @Test
    public void webTableHW() throws InterruptedException {
        //Homework:
        /* Create a test method: webTableHW
        test if the 6th column includes price of 1000
        test if the first table row has Orlando
        test if there 4th column has Hotel name called Hilton

         */
        login();
        Thread.sleep(5000);
        //test if the 6th column includes price of 1000
        List <WebElement> allSixthColumn=driver.findElements(By.xpath("//td[6]"));
        List <String> allSixthColumnText=new ArrayList<String>();
        for(WebElement eachSixthColumn:allSixthColumn){
            allSixthColumnText.add(eachSixthColumn.getText());
        }
        Assert.assertTrue(allSixthColumnText.contains("1,000.00"));

        //test if the first table row has Orlando
        List<WebElement>allFirstRowData=driver.findElements(By.xpath("//tbody//tr[1]//td"));
        List<String> allFirstRowDataText=new ArrayList<String>();
        for(WebElement eachFirstRowData:allFirstRowData){
            allFirstRowDataText.add(eachFirstRowData.getText());
        }
        Assert.assertTrue(allFirstRowDataText.contains("Orlando"));

        //test if there 4th column has Hotel name called Hilton
        List <WebElement> allForthColumn=driver.findElements(By.xpath("//td[4]"));
        List <String> allForthColumnText=new ArrayList<String>();
        for(WebElement eachForthColumn:allForthColumn){
            allForthColumnText.add(eachForthColumn.getText());
        }
        Assert.assertTrue(allForthColumnText.contains("Hilton"));

    }


}

