package com.example.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simple")
public class SimpleResource {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topic.simple}")
    private String simpleTopic;

    @GetMapping("/{message}")
    public String post( @PathVariable("message") final String message){
        kafkaTemplate.send(simpleTopic, message)
                .addCallback(System.out::println, System.out::println);
        return "Published successfully";
    }
}
