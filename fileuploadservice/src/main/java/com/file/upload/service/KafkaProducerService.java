package com.file.upload.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.upload.entity.RecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

@Configuration
public class KafkaProducerService {

    @Value("${spring.kafka.topic}")
    private String topicName;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(RecordEntity recordEntity) {
        CompletableFuture<SendResult<String, String>> future = null;
        try {
            future = kafkaTemplate.send(topicName,
                    objectMapper.writeValueAsString(recordEntity));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + recordEntity.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        recordEntity.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
