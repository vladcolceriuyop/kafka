package com.example.kafka.resource;

import com.example.kafka.model.User;
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
    KafkaTemplate<String, User> kafkaTemplate;
    @Value("${kafka.topic.example}")
    private String topic;

    @GetMapping("/{name}")
    public String post( @PathVariable("name") final String name){
        kafkaTemplate.send(topic,new User(name,"IT",20000L))
                .addCallback(System.out::println, System.out::println);
        return "Published successfully";
    }
}
