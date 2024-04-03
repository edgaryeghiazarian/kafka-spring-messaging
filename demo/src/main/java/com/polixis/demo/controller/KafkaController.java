package com.polixis.demo.controller;

import com.polixis.demo.converter.MessageConverter;
import com.polixis.demo.entity.Message;
import com.polixis.demo.model.MessageDTO;
import com.polixis.demo.model.MessageResponseJson;
import com.polixis.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private final MessageService messageService;

    @Autowired
    public KafkaController(MessageService messageService, MessageConverter messageConverter) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) {
        Message message = messageService.saveMessage(messageDTO);
        return new ResponseEntity<>(new MessageResponseJson(message.getMessageKey(),
                message.getMessageValue()), HttpStatus.OK);
    }
}
