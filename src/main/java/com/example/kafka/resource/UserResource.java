package com.example.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    @Value("${kafka.topic.example}")
    private String topic;

    @GetMapping("/publish/{message}")
    public String post( @PathVariable("message") final String message){
        kafkaTemplate.send(topic,message);

        return "Published successfully";
    }
}
