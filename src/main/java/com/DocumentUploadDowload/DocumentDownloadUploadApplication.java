package com.DocumentUploadDowload;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DocumentDownloadUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentDownloadUploadApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
