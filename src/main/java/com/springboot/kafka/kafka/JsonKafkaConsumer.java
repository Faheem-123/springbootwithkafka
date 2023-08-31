package com.springboot.kafka.kafka;

import com.springboot.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
    //this annotation listen or subscribe message comming from producer topic
    @KafkaListener(topics = "myJsonTopic", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json Message received %s", user.toString()));
    }
}
