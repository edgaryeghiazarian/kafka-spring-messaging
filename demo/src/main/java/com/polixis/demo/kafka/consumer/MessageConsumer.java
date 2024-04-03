package com.polixis.demo.kafka.consumer;

import com.polixis.demo.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(Message message) {
        log.info("Message received: " + message);
    }
}
