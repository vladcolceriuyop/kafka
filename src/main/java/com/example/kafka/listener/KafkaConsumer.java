package com.example.kafka.listener;

import com.example.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.simple}", groupId = "group_id")
    public void consume(String message) {
        System.out.println(String.format("Consumed message: %s", message));
    }

    @KafkaListener(topics = "${kafka.topic.user}", groupId = "group_json", containerFactory = "userListenerContainerFactory")
    public void consumeJson(User user) {
        System.out.println(String.format("Consumed user: %s", user.toString()));
    }

}
