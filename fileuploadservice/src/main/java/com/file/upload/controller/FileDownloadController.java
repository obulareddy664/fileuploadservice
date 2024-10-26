package com.file.upload.controller;

import com.file.upload.service.FileDownloadService;
import com.file.upload.utility.ExcelGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileDownloadController {


    @Autowired
    private FileDownloadService fileDownloadService;

    @GetMapping("/export-to-excel/{id}")
    public void exportIntoExcelFile(HttpServletResponse response, @PathVariable("id") BigInteger id) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=product" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ExcelGenerator generator = new ExcelGenerator(fileDownloadService.getRecordLogs(id));
        generator.generateExcelFile(response);
        response.flushBuffer();
    }

}
