package com.springboot.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic getKafkaTopicBean(){
        return TopicBuilder.name("myTopic").build();
    }

    @Bean
    public NewTopic getJsonKafkaTopicBean(){
        return TopicBuilder.name("myJsonTopic").build();
    }

    @Bean
    public NewTopic wikimediaKafkaTopicBean(){
        return TopicBuilder.name("wikimediaTopic").build();
    }
}
