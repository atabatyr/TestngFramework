package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    //Create a new class: Write Excel
    //Create a new method writeExcel()
    @Test
    public void writeExcel() throws IOException {
        //Store the path of the file as string and open the file
        String path=".\\src\\test\\java\\resources\\Capitals.xlsx";
        //Open the workbook
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //Open the first worksheet
        Sheet sheet=workbook.getSheetAt(0);
        //Go to the first row
        Row row=sheet.getRow(0);
        //create a cell on the 3rd index on the first row(D1)
        Cell cell4=row.createCell(3);
        //Write "Population" on the cell
        cell4.setCellValue("Population");
        //Create a cell on the 2nd row 4th cell(index3), and write 150000
        sheet.getRow(1).createCell(3).setCellValue("150000");
        //Create a cell on the 3rd row 4th cell(index3), and write 250000
        sheet.getRow(2).createCell(3).setCellValue("250000");
        //Create a cell on the 4th row 4th cell(index3), and write 54000
        sheet.getRow(3).createCell(3).setCellValue("54000");
        //write and save the workbook
        //FileInputStream is to READ, FileOutputStrem is to WRITE
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        //close the workbook
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

}
