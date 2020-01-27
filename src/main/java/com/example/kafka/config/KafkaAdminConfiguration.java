package com.example.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfiguration {

    @Value(value="${spring.kafka.bootstrap-servers}")
    private String[] bootstrapAddresses;

    @Value("${kafka.topic.simple}")
    private String simpleTopic;

    @Value("${kafka.topic.user}")
    private String userTopic;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,String.join(",",bootstrapAddresses));
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic simpleTopic(){
        return new NewTopic(simpleTopic,1,(short)1);
    }

    @Bean
    public NewTopic userTopic(){
        return new NewTopic(userTopic,1,(short)1);
    }
}
