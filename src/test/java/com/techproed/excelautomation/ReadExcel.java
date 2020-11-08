package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {
        //Store the path of the file in a string
        String path=".\\src\\test\\java\\resources\\Capitals.xlsx";
        // Open the file
        FileInputStream fileInputStream=new FileInputStream(path);
        // Open the workbook using fileinputstream
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //Open the first worksheet
        Sheet sheet=workbook.getSheetAt(0);
        // Go to first row
        Row row=sheet.getRow(0);
        // Go to first cell on that first row and print
        Cell cell=row.getCell(0);
        System.out.println("Data in the first cell: "+cell);
        // Go to second cell on that first row and print
        Cell cell1=row.getCell(1);
        //String cell1=row.getCell(1).toString();
        System.out.println(cell1);
        // Go to 2nd row first cell
        //We can chain to get data

        String france= workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(france);
        //Go to 3rd row 2nd cell-chain the row and cell
        String ottowa=workbook.getSheetAt(0).getRow(2).getCell(1).toString();
        // Find the number of row
        int rowCount=sheet.getLastRowNum();//Getting the last row number that is used. Index start at 0. THis gives up 1 less
        System.out.println("Row Count : "+(++rowCount));
        // Find the number of used row
        int numOfPhysicalRow=sheet.getPhysicalNumberOfRows();//Index starts at 1. This will give us only the number of row that is used
        System.out.println("Number Cell That is Used : "+numOfPhysicalRow);
        // Print country capital key value pairs as map object
        Map<String, String> capitals=new HashMap<>();
        int countryColumn=0;
        int capitalColumn=1;
        for(int rowNumber=1;rowNumber<rowCount;rowNumber++){

            String country=sheet.getRow(rowNumber).getCell(0).toString();
            String capital=sheet.getRow(rowNumber).getCell(1).toString();
            System.out.println(country+" : "+capital);//PRINTING ALL O THE COUNTRIES AND CAPITALS
            capitals.put(country,capital);
        }
        System.out.println(capitals);
        fileInputStream.close();
        workbook.close();


    }

}
