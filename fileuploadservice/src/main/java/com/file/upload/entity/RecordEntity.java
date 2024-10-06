package com.file.upload.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	private String name;
	
	private String competetior;
	
	private Double conversionFactor;
	
	private BigInteger fileId;
	
	private LocalDateTime createdTime;

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getFileId() {
		return fileId;
	}

	public void setFileId(BigInteger fileId) {
		this.fileId = fileId;
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

	public RecordEntity(String name, String competetior, Double conversionFactor) {
		super();
		this.name = name;
		this.competetior = competetior;
		this.conversionFactor = conversionFactor;
	}

	public RecordEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
