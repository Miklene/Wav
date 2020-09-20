package com.example.wav;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    FileInputStream file;
    public void findExcel() throws IOException {
        file = new FileInputStream(new File("D:\\Skripka.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook (file);
    }
}
