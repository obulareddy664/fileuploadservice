package com.file.upload.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.upload.entity.RecordLogs;

@Repository
public interface RecordsLogsEntity extends JpaRepository<RecordLogs, BigInteger> {

}
