package com.file.upload.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.file.upload.entity.RecordEntity;
import com.file.upload.model.Product;
import org.apache.kafka.common.serialization.Serializer;
import org.hibernate.type.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomSerializer implements Serializer<RecordEntity> {

    Logger logger= LoggerFactory.getLogger(CustomSerializer.class);

    @Autowired
    private final ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public byte[] serialize(String topic, RecordEntity data) {
        try{
            if(data==null){
               logger.info("Null received during serialization");
                return null;
            }
            logger.info("Serializing........");
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            logger.error("error received while CustomSerializer");
            throw new SerializationException("Error while receiving exception to byte []",e);
        }

    }

    @Override
    public void close() {

    }
}
