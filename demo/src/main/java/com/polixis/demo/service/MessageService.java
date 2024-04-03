package com.polixis.demo.service;

import com.polixis.demo.converter.MessageConverter;
import com.polixis.demo.entity.Message;
import com.polixis.demo.kafka.producer.MessageProducer;
import com.polixis.demo.model.MessageDTO;
import com.polixis.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageConverter messageConverter;
    private final MessageProducer messageProducer;


    @Autowired
    public MessageService(MessageRepository messageRepository, MessageConverter messageConverter, MessageProducer messageProducer) {
        this.messageRepository = messageRepository;
        this.messageConverter = messageConverter;
        this.messageProducer = messageProducer;
    }

    @Transactional
    public Message saveMessage(MessageDTO messageDTO) {
        Message message = messageConverter.convertToEntity(messageDTO, new Message());
        Message savedMessage = messageRepository.save(message);
        messageProducer.sendMessage("my-topic", savedMessage);
        return savedMessage;
    }
}
