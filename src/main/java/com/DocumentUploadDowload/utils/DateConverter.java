package com.DocumentUploadDowload.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class DateConverter {

	public String dateConvertion(String date) {
		String result="";
		SimpleDateFormat dbFormat=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		SimpleDateFormat UIFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date converter= dbFormat.parse(date);
			result=UIFormat.format(converter);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
