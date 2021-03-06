package com.example.demo.reporting;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font; 

public class Layouter {
	 public static void buildOfficeTemplate(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
         worksheet.setColumnWidth(0, 5000);
         worksheet.setColumnWidth(1, 5000);
         worksheet.setColumnWidth(2, 5000);
         worksheet.setColumnWidth(3, 7000);
         worksheet.setColumnWidth(4, 7000);
         
         Font font = worksheet.getWorkbook().createFont();
        // font.setBoldweight(Font.BOLDWEIGHT_BOLD);
         
         HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
        // headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
         headerCellStyle.setWrapText(true);
         headerCellStyle.setFont(font);
        // headerCellStyle.setBorderRight(CellStyle.BORDER_THICK);
        // headerCellStyle.setBorderBottom(CellStyle.BORDER_THICK);
         
         HSSFRow rowHeader = worksheet.createRow((short) startRowIndex);
         rowHeader.setHeight((short) 500);
         
         HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
         cell1.setCellValue("External_id");
         cell1.setCellStyle(headerCellStyle);
         
         HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
         cell2.setCellValue("hierarchy");
         cell2.setCellStyle(headerCellStyle);
         
         HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
         cell3.setCellValue("Name");
         cell3.setCellStyle(headerCellStyle);
         HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
         cell4.setCellValue("Opening date");
         cell4.setCellStyle(headerCellStyle);
         HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
         cell5.setCellValue("Parent id ");
         cell5.setCellStyle(headerCellStyle);
          
   }

}
