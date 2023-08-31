package com.springboot.kafka.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.springboot.kafka.payload.WikimediaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        //to read real time data from wikimedia, we use eventsource
        EventHandler eventHandler=new WikimediaHandler(kafkaTemplate,"wikimediaTopic");
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder= new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();
        TimeUnit.SECONDS.sleep(2);
    }
}
