package com.DocumentUploadDowload.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.DocumentUploadDowload.models.DocumentModel;

@Service
public class ExcelHelper {

	@Autowired
	DateConverter dateConverter;

	public List<DocumentModel> convertExcelToList(InputStream is) {
		List<DocumentModel> list = new ArrayList<DocumentModel>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet dataSheet = workbook.getSheet("info");

			int rowNumber = 0;
			Iterator<Row> iterator = dataSheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				DocumentModel model = new DocumentModel();
				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						model.setUserName(StringUtils.capitalize(cell.getStringCellValue()));
						break;
					case 1:
						if (cell.getDateCellValue() == null)
							break;
						model.setDateOfBirth(dateConverter.dateConvertion(cell.getDateCellValue().toString()));
						break;
					case 2:
						model.setGender(StringUtils.capitalize(cell.getStringCellValue()));
						break;
					case 3:
						model.setEmail(cell.getStringCellValue());
						break;
					case 4:
						model.setPhoneNumber(NumberToTextConverter.toText(cell.getNumericCellValue()));
						break;
					default:
						break;
					}
					UUID uuid = UUID.randomUUID();
					model.setUserID(uuid.toString());
					cid++;
				}
				list.add(model);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return list;
	}
}
