package com.file.upload.controller;

import com.file.upload.entity.File;
import com.file.upload.service.UploadService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping
public class FileUploadController {

    Logger log = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload a file", description = "Uploads a file using multipart/form-data")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        log.info(" upload file  Started ::  ");
        File data = uploadService.insertFile(file);
        log.info(" upload file  Started ::  ");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<String> value() {
        return new ResponseEntity("string", HttpStatus.OK);

    }
}
