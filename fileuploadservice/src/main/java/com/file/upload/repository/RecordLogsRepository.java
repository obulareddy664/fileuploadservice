package com.file.upload.repository;

import com.file.upload.entity.RecordLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface RecordLogsRepository extends JpaRepository<RecordLogs, BigInteger> {

    public List<RecordLogs> findAllByFileId(BigInteger fileId);
}
