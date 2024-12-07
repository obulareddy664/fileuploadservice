package com.file.upload.service;

import com.file.upload.constant.RecordErrorMsg;
import com.file.upload.entity.File;
import com.file.upload.entity.RecordEntity;
import com.file.upload.entity.RecordLogs;
import com.file.upload.exception.FileNameException;
import com.file.upload.model.Product;
import com.file.upload.repository.FileRepository;
import com.file.upload.repository.RecordEntityRepository;
import com.file.upload.repository.RecordLogsRepository;
import com.file.upload.utility.Converter;
import com.file.upload.utility.ExcelConverterUtility;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {

    @Autowired
    private RecordEntityRepository recordEntityRepository;

    @Autowired
    private RecordLogsRepository recordsLogsRepository;

    @Autowired
    private FileRepository fileRepository;

    public File insertFile(MultipartFile file) throws IOException {
        if (isFileName(file.getOriginalFilename())) {
            File fileData = saveFile(file);
            try {
                saveValidAndInvalidRecords(file, fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileData;
        }
        return null;
    }


    public boolean isFileName(String name) {
        boolean fileName = fileRepository.existsFileByName(name);
        if (fileName) {
            throw new FileNameException(name);
        }
        return true;
    }

    private void saveValidAndInvalidRecords(MultipartFile file, File fileData) throws IOException {
        List<Product> list = ExcelConverterUtility.convertToModel(file);
        List<RecordEntity> validRecords = new ArrayList<>();
        List<RecordLogs> validAndInvalidRecords = new ArrayList<>();
        list.forEach(record -> {
            String message = Converter.recordValidate(record);
            if (message.isEmpty()) {
                validRecords.add(Converter.convertModelEntity(record, fileData.getId()));
                validAndInvalidRecords.add(Converter.convertToRecordLogs(record, message, RecordErrorMsg.SUCCESS, fileData.getId()));
            } else {
                validAndInvalidRecords.add(Converter.convertToRecordLogs(record, message, RecordErrorMsg.FAILURE, fileData.getId()));
            }
        });

        saveValidAndInvalidRecordList(validRecords, validAndInvalidRecords);
    }

    private void saveValidAndInvalidRecordList(List<RecordEntity> validRecords, List<RecordLogs> validAndInvalidRecords) {
        if (!validRecords.isEmpty()) {
            recordEntityRepository.saveAll(validRecords);
        }
        if (!validAndInvalidRecords.isEmpty()) {
            recordsLogsRepository.saveAll(validAndInvalidRecords);
        }
    }

    private @NotNull File saveFile(MultipartFile file) throws IOException {
        File fi = new File();
        fi.setName(file.getOriginalFilename());
        fi.setCreatedTime(LocalDateTime.now());
        fi.setContent(file.getBytes());
        return fileRepository.save(fi);
    }

    public List<RecordLogs> grtRecordLogs(Iterable<BigInteger> ids) {
        return recordsLogsRepository.findAllById(ids);
    }

}
