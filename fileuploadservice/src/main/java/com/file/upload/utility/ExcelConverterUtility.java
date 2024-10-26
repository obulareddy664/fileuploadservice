package com.file.upload.utility;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.entity.RecordEntity;
import com.file.upload.model.Product;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;


public class ExcelConverterUtility {

	private ExcelConverterUtility(){}
	
	public  static List<Product> convertToModel(MultipartFile multipartFile) throws IOException {
		
		return Poiji.fromExcel(multipartFile.getInputStream(),PoijiExcelType.XLSX, Product.class);
	}
	
	
}
