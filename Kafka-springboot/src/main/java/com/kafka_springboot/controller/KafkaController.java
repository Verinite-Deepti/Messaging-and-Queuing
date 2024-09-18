package com.kafka_springboot.controller;

import com.kafka_springboot.producer.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String topic, @RequestParam String message) {
        try {
            kafkaProducerService.sendMessage(topic, message);
            return ResponseEntity.ok("Message sent to " + topic);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }

    @GetMapping("/send-to-partition")
    public ResponseEntity<String> sendMessageToPartition(
        @RequestParam String topic,
        @RequestParam int partition,
        @RequestParam String message
    ) {
        try {
            kafkaProducerService.sendMessageToPartition(topic, partition, message);
            return ResponseEntity.ok("Message sent to topic " + topic + " at partition " + partition);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }

  
}
