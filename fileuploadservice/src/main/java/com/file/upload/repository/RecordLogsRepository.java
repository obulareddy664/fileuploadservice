package com.file.upload.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.upload.entity.RecordLogs;

@Repository
public interface RecordLogsRepository extends JpaRepository<RecordLogs, BigInteger> {

    public List<RecordLogs> findAllByFileId(BigInteger fileId);
}
