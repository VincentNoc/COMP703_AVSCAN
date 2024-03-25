/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excel;

/**
 *
 * @author dmitr
 */
import Database.HistoryData;
import java.io.File;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    private ArrayList<HistoryData> historyDataList = new ArrayList<>();

    public ExcelWriter() {
        //createAndWriteHistory();
    }

    public void addToExcel(HistoryData imported) {
        historyDataList.add(imported);
    }

    public void createAndWriteHistory() {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook(); // For .xlsx format
        //Workbook workbook = new HSSFWorkbook(); // For .xls format

        // Create a blank sheet
        Sheet sheet = workbook.createSheet("History Data");

        // Create some data rows
        int rowNum = 0;
        String[] headers = {"Event ID", "Equipment ID", "Equipment Name", "Parent ID", "Parent Name", "Returned", "Staff"};
        Row headerRow = sheet.createRow(rowNum++);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
        for (HistoryData data : historyDataList) {
            Row row = sheet.createRow(rowNum++);

            System.out.println("EvID: " + data.getEvID());
            
            row.createCell(0).setCellValue(data.getEvID());
            row.createCell(1).setCellValue(data.getEvEquipmentID());
            row.createCell(2).setCellValue(data.getEquipmentName());
            row.createCell(3).setCellValue(data.getParentID());
            row.createCell(4).setCellValue(data.getParentName());
            Cell dateCell = row.createCell(5);
            dateCell.setCellValue(data.getEqReturnDateTime());
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            dateCell.setCellStyle(cellStyle);
            row.createCell(6).setCellValue(data.getEvCheckOutStaff());
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Create a file location chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Excel File");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Append ".xlsx" extension if not already present
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }
            
            // Write the workbook content to the specified file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("Excel file has been created successfully at: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Excel file creation was canceled.");
        }
    }
}
