package com.example.demo.service;






import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.stereotype.Service;

import com.example.demo.Writer;
import com.example.demo.reporting.Layouter;

@Service("downloadService")
@Transactional

public class DownloadService {
	 public void downloadXLS(HttpServletResponse response,String viewType) throws ClassNotFoundException {
	        //logger.info("Downloading Excel Template");
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet worksheet = workbook.createSheet("Offices");
	         int startRowIndex = 0;
	         int startColIndex = 0;
	         Layouter.buildOfficeTemplate(worksheet, startRowIndex, startColIndex);
	         String fileName = viewType+".xls";
	         response.setHeader("Content-Disposition", "inline; filename=" + fileName);
	         response.setContentType("application/vnd.ms-excel");
	         Writer.write(response, worksheet);
}
}