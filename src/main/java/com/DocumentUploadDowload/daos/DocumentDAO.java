package com.DocumentUploadDowload.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocumentUploadDowload.models.DocumentModel;

@Repository
public interface DocumentDAO extends JpaRepository<DocumentModel, String>{
	
}
