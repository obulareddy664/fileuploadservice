package com.file.upload.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecordLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	private String name;

	private String competetior;

	private Double conversionFactor;
	
	private String status;

	private String message;
	
	private BigInteger recordId;
	
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

	public BigInteger getRecordId() {
		return recordId;
	}

	public void setRecordId(BigInteger recordId) {
		this.recordId = recordId;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RecordLogs(BigInteger id, String name, String competetior, Double conversionFactor, String status,
			String message) {
		super();
		this.id = id;
		this.name = name;
		this.competetior = competetior;
		this.conversionFactor = conversionFactor;
		this.status = status;
		this.message = message;
	}

	public RecordLogs() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
