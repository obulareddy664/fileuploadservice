package com.file.upload.utility;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.entity.RecordEntity;
import com.file.upload.model.Record;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;


public class ExcelConverterUtility {

	
	public  static List<Record> convertToModel(MultipartFile multipartFile) throws IOException {
		
		return Poiji.fromExcel(multipartFile.getInputStream(),PoijiExcelType.XLSX, Record.class);
	}
	
	
}
