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
	
	private BigInteger fileId;

	private LocalDateTime createdTime;

	private LocalDateTime updatedTime;

	public RecordLogs(BigInteger id, String name, String competetior, Double conversionFactor, String status, String message, BigInteger fileId, LocalDateTime createdTime, LocalDateTime updatedTime) {
		this.id = id;
		this.name = name;
		this.competetior = competetior;
		this.conversionFactor = conversionFactor;
		this.status = status;
		this.message = message;
		this.fileId = fileId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public BigInteger getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCompetetior() {
		return competetior;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public BigInteger getFileId() {
		return fileId;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public RecordLogs() {
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompetetior(String competetior) {
		this.competetior = competetior;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFileId(BigInteger fileId) {
		this.fileId = fileId;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
}
