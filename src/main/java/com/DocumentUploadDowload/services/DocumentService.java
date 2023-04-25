package com.DocumentUploadDowload.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.DocumentUploadDowload.models.DocumentModel;

public interface DocumentService {
	
	List<DocumentModel> fetchAllData();
	
	void uploadExcel(MultipartFile file);
}
