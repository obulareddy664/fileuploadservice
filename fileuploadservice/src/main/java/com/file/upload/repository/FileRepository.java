package com.file.upload.repository;

import com.file.upload.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FileRepository extends JpaRepository<File, BigInteger> {

    boolean existsFileByName(String name);
}