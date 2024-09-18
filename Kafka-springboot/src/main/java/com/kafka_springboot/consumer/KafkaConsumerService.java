package com.kafka_springboot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "banking", groupId = "my-group")
    public void listenBanking(String message, Acknowledgment acknowledgment) {
        System.out.println("Received message from banking topic: " + message);
        acknowledgment.acknowledge(); 
    }

    @KafkaListener(topics = "user", groupId = "my-group")
    public void listenUser(String message, Acknowledgment acknowledgment) {
        System.out.println("Received message from user topic: " + message);
        acknowledgment.acknowledge(); 
    }
}
