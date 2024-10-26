package com.file.upload.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.file.upload.entity.RecordLogs;
import com.file.upload.utility.ExcelGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.entity.File;
import com.file.upload.service.UploadService;

@RestController
public class FileUploadController {

	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		
	File data=	uploadService.insertFile(file);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@GetMapping("/data")
	public ResponseEntity<String> value(){
		return new ResponseEntity("string",HttpStatus.OK);
	}

}
