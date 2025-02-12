package com.file.upload.service;

import com.file.upload.entity.RecordLogs;
import com.file.upload.repository.RecordLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FileDownloadService {

    @Autowired
    RecordLogsRepository recordLogsRepository;

    public List<RecordLogs> getRecordLogs(BigInteger fileId) {

        return recordLogsRepository.findAllByFileId(fileId);
    }
}
