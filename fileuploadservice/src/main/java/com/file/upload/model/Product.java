package com.file.upload.model;

import com.poiji.annotation.ExcelCellName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

	@ExcelCellName("name")
	private String name;
	
	@ExcelCellName("competetior")
	private String competetior;
	
	@ExcelCellName("conversionFactor")
	private Double conversionFactor;

}
