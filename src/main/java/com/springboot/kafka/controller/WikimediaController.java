package com.springboot.kafka.controller;

import com.springboot.kafka.kafka.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class WikimediaController {

    @Autowired
    private WikimediaProducer wikimediaProducer;

    @GetMapping("/wikimedia")
    public ResponseEntity<String> sendMessage() throws InterruptedException {
        wikimediaProducer.sendMessage();
        return ResponseEntity.ok("Wikimedia message sent successfully to WiimediaTopic !!");
    }
}
