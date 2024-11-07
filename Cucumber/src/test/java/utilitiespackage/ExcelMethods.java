package utilitiespackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import com.google.common.collect.Table.Cell;

public class ExcelMethods {
    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
     
    }

   // public static String getCellData(int rowNum, int colNum) {
       // Row row = sheet.getRow(rowNum);
       // Cell cell = row.getCell(colNum);
        //return cell.getStringCellValue();
    }

