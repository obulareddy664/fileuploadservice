package com.file.upload.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	private String name;
	
	private LocalDateTime createdTime;

}
