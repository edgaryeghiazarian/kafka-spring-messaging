package com.polixis.demo.kafka.producer;

import com.polixis.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Autowired
    public MessageProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
