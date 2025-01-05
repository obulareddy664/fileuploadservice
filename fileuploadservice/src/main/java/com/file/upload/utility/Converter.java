package com.file.upload.utility;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.file.upload.constant.RecordErrorMsg;
import com.file.upload.entity.RecordEntity;
import com.file.upload.entity.RecordLogs;
import com.file.upload.model.Product;

public class Converter {

	public static RecordEntity convertModelEntity(Product record,BigInteger id) {
		RecordEntity re=new RecordEntity();
		re.setName(record.getName());
		re.setConversionFactor(record.getConversionFactor());
		re.setCompetetior(record.getCompetetior());
		re.setFileId(id);
		
		return re;
	}
	
	public static String recordValidate(Product record) {
		String name = record.getName();
		String message = "";
		String competetior=record.getCompetetior();
		Double conversionFactor=record.getConversionFactor();
		if (name == null || name.isEmpty()) {
		return	message = RecordErrorMsg.NAME;
		}else if((competetior== null || competetior.isEmpty()) || !(competetior.equals("AMZ") || competetior.equals("WMT"))){
				return message = RecordErrorMsg.COMPETETIOR;
		} else if (conversionFactor<0) {
		return	message=RecordErrorMsg.CONVERSASTION_FACTOR;
		}
		return message;

	}

	public static void main(String[] args) {
		Product product=new Product();
		product.setName("data");
		product.setCompetetior("AMZ");


		System.out.println(recordValidate(product));
	}
	
	public static RecordLogs convertToRecordLogs(Product record, String message,String status,BigInteger id) {

		RecordLogs rl = new RecordLogs();

		rl.setCompetetior(record.getCompetetior());
		rl.setConversionFactor(record.getConversionFactor());
		rl.setName(record.getName());
		rl.setStatus(status);
		rl.setMessage(message);
		rl.setCreatedTime(LocalDateTime.now());
		rl.setFileId(id);
		rl.setUpdatedTime(LocalDateTime.now());
		return rl;
	}
}
