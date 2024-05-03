package com.file.upload.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.entity.File;
import com.file.upload.entity.RecordEntity;
import com.file.upload.entity.RecordLogs;
import com.file.upload.model.Record;
import com.file.upload.repository.FileRepository;
import com.file.upload.repository.RecordEntityRepository;
import com.file.upload.repository.RecordsLogsEntity;
import com.file.upload.utility.Converter;
import com.file.upload.utility.ExcelConverterUtility;

@Service
public class UploadService {

	@Autowired
	private RecordEntityRepository recordEntityRepository;

	@Autowired
	private RecordsLogsEntity recordsLogsEntity;

	@Autowired
	private FileRepository fileRepository;

	public File insertFile(MultipartFile file) {
		File fi = new File();
		fi.setName(file.getName());
		fi.setCreatedTime(LocalDateTime.now());

		File fileData = fileRepository.save(fi);
		try {

			List<Record> list = ExcelConverterUtility.convertToModel(file);

			List<RecordEntity> validRecords = new ArrayList<>();

			List<RecordLogs> InvalidRecords = new ArrayList<>();

			list.forEach(record -> {

				String message = Converter.recordValidate(record);
				if (message.isEmpty()) {
					validRecords.add(Converter.convertModelEntity(record, fileData.getId()));
					InvalidRecords.add(Converter.convertToRecordLogs(record, message, "SUCCESS", fileData.getId()));
				} else {
					InvalidRecords.add(Converter.convertToRecordLogs(record, message, "FAILURE", fileData.getId()));
				}
			});

			recordEntityRepository.saveAll(validRecords);
			recordsLogsEntity.saveAll(InvalidRecords);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return fileData;
	}

}
