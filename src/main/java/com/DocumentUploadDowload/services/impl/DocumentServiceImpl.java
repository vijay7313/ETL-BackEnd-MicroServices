package com.DocumentUploadDowload.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DocumentUploadDowload.daos.DocumentDAO;
import com.DocumentUploadDowload.models.DocumentModel;
import com.DocumentUploadDowload.services.DocumentService;
import com.DocumentUploadDowload.utils.ExcelHelper;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentDAO documentDAO;

	@Autowired
	ExcelHelper helper;

	public List<DocumentModel> fetchAllData() {

		// fetch the data from DB.
		return documentDAO.findAll();
	}

	public void uploadExcel(MultipartFile file) {

		try {
			
			// Excel to list
			List<DocumentModel> list = helper.convertExcelToList(file.getInputStream());
			
			// Save the list to DB
			documentDAO.saveAll(list);
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
	}

}
