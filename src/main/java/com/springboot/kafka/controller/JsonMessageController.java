package com.springboot.kafka.controller;

import com.springboot.kafka.kafka.JsonKafkaProducer;
import com.springboot.kafka.kafka.KafkaProducer;
import com.springboot.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/send-user-message")
    public ResponseEntity<User> sendJsonMessage(@RequestBody User user){
        jsonKafkaProducer.sendJsonMessage(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
