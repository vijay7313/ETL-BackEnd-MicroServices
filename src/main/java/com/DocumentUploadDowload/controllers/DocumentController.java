package com.DocumentUploadDowload.controllers;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.DocumentUploadDowload.models.DocumentModel;
import com.DocumentUploadDowload.dtos.DocumentDTO;
import com.DocumentUploadDowload.services.DocumentService;

@RestController
@RequestMapping("/documentController")
@CrossOrigin(origins = "http://localhost:4200/")
public class DocumentController {

	@Autowired(required = true)
	DocumentService documentService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/dowloadDocument")
	public List<DocumentDTO> getAllData() {

		// Get the data from service class.
		List<DocumentModel> model = documentService.fetchAllData();

		// change the data, entity to DTO.
		List<DocumentDTO> postDTOList = modelMapper.map(model, new TypeToken<List<DocumentDTO>>() {
		}.getType());

		return postDTOList;
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String results="";
		try {
			documentService.uploadExcel(file);
			results="1";
		}
		catch (Exception e) {
			results="0";
		}
		
		return results;
	}

}
