package com.file.upload.utility;

import com.file.upload.entity.RecordLogs;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class ExcelGenerator {

    private List <RecordLogs> recordEntityList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < RecordLogs > recordEntityList) {
        this.recordEntityList = recordEntityList;
        workbook = new XSSFWorkbook();
    }
    private void writeHeader() {
        sheet = workbook.createSheet("Product");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Record Name", style);
        createCell(row, 1, "Competetior", style);
        createCell(row, 2, "Conversion Factor", style);
        createCell(row, 3, "Status", style);
        createCell(row, 4, "Error Description", style);
        createCell(row, 3, "Created Time", style);
    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Double) {
            cell.setCellValue((Double) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }

        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (RecordLogs record: recordEntityList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getName(), style);
            createCell(row, columnCount++, record.getCompetetior(), style);
            createCell(row, columnCount++, record.getConversionFactor(), style);
            createCell(row, columnCount++, record.getStatus(), style);
            createCell(row, columnCount++, record.getMessage(), style);
            createCell(row, columnCount++, record.getCreatedTime(), style);

        }
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}