package com.kafka_springboot;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@SpringBootTest
public class KafkaIntegrationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Test
    public void testSendMessage() {
        // Send a batch of messages
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send("banking", "Test message " + i);
        }

        // Verify that messages are sent
        // Add logic to verify batch sending and manual offset management
    }
}
