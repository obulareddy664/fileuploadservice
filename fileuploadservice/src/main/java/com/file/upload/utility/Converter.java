package com.file.upload.utility;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.file.upload.entity.RecordEntity;
import com.file.upload.entity.RecordLogs;
import com.file.upload.model.Product;

public class Converter {

	public static RecordEntity convertModelEntity(Product record,BigInteger id) {
		RecordEntity re=new RecordEntity();
		re.setName(record.getName());
		re.setConversionFactor(record.getConversionFactor());
		re.setCompetetior(record.getCompetetior());
		re.setCreatedTime(LocalDateTime.now());
		re.setRecordId(id);
		
		return re;
	}
	
	public static String recordValidate(Product record) {
		String name = record.getName();
		String message = "";

		if (name == null || name.isEmpty()) {
			message = "name must be provided";
		}

		return message;

	}
	
	public static RecordLogs convertToRecordLogs(Product record, String message,String status,BigInteger id) {

		RecordLogs rl = new RecordLogs();

		rl.setCompetetior(record.getCompetetior());
		rl.setConversionFactor(record.getConversionFactor());
		rl.setName(record.getName());
		rl.setStatus(status);
		rl.setMessage(message);
		rl.setCreatedTime(LocalDateTime.now());
		rl.setRecordId(id);
		return rl;
	}
}
