package com.file.upload.repository;

import com.file.upload.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RecordEntityRepository extends JpaRepository<RecordEntity, BigInteger> {

}
