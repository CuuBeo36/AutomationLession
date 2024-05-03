package com.luma.utils;

import com.sun.jna.WString;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {
    static Logger log = Logger.getLogger(com.luma.utils.ReadExcelFile.class.getName());
    public String readData (){
        String searchText = null;
        try {
            String filepath = Data.getProperty("testDataFile");
            FileInputStream file = new FileInputStream(new File(filepath));

            // Create Workbook instance holding reference to .xlsx file
            Workbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            log.info(cell.getNumericCellValue() + "\t");
                            searchText = cell.getNumericCellValue() + "\t";
                            break;
                        case STRING:
                            log.info(cell.getStringCellValue() + "\t");
                            searchText = cell.getStringCellValue() + "\t";
                            break;
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchText;
    }
}
