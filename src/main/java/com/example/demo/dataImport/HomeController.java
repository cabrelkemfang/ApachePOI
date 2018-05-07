package com.example.demo.dataImport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Office;
import com.example.demo.repository.OfficeRepo;
import com.example.demo.service.DownloadService;

@RestController
public class HomeController {

	// @Autowired
	private OfficeRepo _officeRpeo;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "downloadService")
	private DownloadService downloadService;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void home(@RequestParam("entity") String viewType, HttpServletResponse response, Model model)
			throws ClassNotFoundException {
		logger.info("The client wants to view {}.", viewType);
		downloadService.downloadXLS(response, viewType);
	}


	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ResponseEntity<String> handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.getContentType().equals("application/vnd.ms-excel")) {
			throw new MultipartException("Only excel files accepted!");
		} else {
			HSSFWorkbook offices = new HSSFWorkbook(file.getInputStream());
			HSSFSheet firstSheet = offices.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				int col = 0;
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				String externalId = null;
				String hierarchy = null;
				String name = null;
				String openingDate = null;
				String parentId = null;

				while (cellIterator.hasNext()) {
					HSSFCell cell = (HSSFCell) cellIterator.next();

					if (col == 0)
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							externalId = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							externalId = Double.toString(cell.getNumericCellValue());
							break;

						}
					if (col == 1)
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							hierarchy = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							hierarchy = Double.toString(cell.getNumericCellValue());
							break;

						}
					if (col == 2)
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							name = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							name = Double.toString(cell.getNumericCellValue());
							break;

						}
					if (col == 3)
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							externalId = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							externalId = Double.toString(cell.getNumericCellValue());
							break;

						}
					if (col == 4)
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							openingDate = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							openingDate = Double.toString(cell.getNumericCellValue());
							break;

						}
					if (col == 5) {
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							parentId = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							parentId = Double.toString(cell.getNumericCellValue());
							break;

						}
					}
					col++;
				}

				System.out.print(" " + externalId + " " + hierarchy + " " + name + " " + externalId + " " + parentId);
			}

			return new ResponseEntity<>("Upload successuly", HttpStatus.OK);
		}
	}
}
