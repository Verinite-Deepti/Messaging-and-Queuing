package com.kafka_springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic bankingTopic() {
        return new NewTopic("banking", 3, (short) 2); // 3 partitions, replication factor of 2
    }

    @Bean
    public NewTopic userTopic() {
        return new NewTopic("user", 3, (short) 2); // 3 partition, replication factor of 2
    }
}
