/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

/**
 *
 * @author dmitr
 */
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    public ExcelWriter() {
        createAndWrite();
    }
    

    public void createAndWrite() {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook(); // For .xlsx format
        //Workbook workbook = new HSSFWorkbook(); // For .xls format

        // Create a blank sheet
        Sheet sheet = workbook.createSheet("Sample Sheet");

        // Create some data rows
        Object[][] data = {
            {"Name", "Age", "Gender"},
            {"John Doe", 30, "Male"},
            {"Jane Smith", 25, "Female"},
            {"Tom Brown", 35, "Male"}
        };

        // Write the data to the Excel file
        int rowNum = 0;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        // Write the workbook content to a file
        String filePath = "C:\\Users\\dmitr\\OneDrive\\Desktop\\java.xlsx"; // Specify the file path
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
