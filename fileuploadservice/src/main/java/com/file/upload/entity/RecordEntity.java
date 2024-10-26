package com.file.upload.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	private String name;
	
	private String competetior;
	
	private Double conversionFactor;
	
	private BigInteger fileId;
	
	private LocalDateTime createdTime;

}
