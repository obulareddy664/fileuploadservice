package com.file.upload.model;

import com.poiji.annotation.ExcelCellName;

public class Record {

	@ExcelCellName("name")
	private String name;
	
	@ExcelCellName("competetior")
	private String competetior;
	
	@ExcelCellName("conversionFactor")
	private Double conversionFactor;

	public Record(String name, String competetior, Double conversionFactor) {
		super();
		this.name = name;
		this.competetior = competetior;
		this.conversionFactor = conversionFactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompetetior() {
		return competetior;
	}

	public void setCompetetior(String competetior) {
		this.competetior = competetior;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
