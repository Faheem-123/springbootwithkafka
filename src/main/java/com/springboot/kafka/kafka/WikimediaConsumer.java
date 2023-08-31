package com.springboot.kafka.kafka;

import com.springboot.kafka.entity.WikimediaData;
import com.springboot.kafka.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaConsumer {

    @Autowired
    private WikimediaRepository wikimediaRepository;
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaConsumer.class);
    //this annotation listen or subscribe message comming from producer topic
    @KafkaListener(topics = "wikimediaTopic", groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Wikimedia message received %s", eventMessage));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setData(eventMessage);
        wikimediaRepository.save(wikimediaData);
    }
}
