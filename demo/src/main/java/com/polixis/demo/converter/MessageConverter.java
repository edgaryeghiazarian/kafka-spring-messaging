package com.polixis.demo.converter;

import com.polixis.demo.entity.Message;
import com.polixis.demo.model.MessageDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter implements Converter<MessageDTO, Message>{
    @Override
    public Message convertToEntity(MessageDTO model, Message entity) {
        entity.setMessageValue(model.getMessageValue());
        entity.setMessageKey(model.getMessageKey());
        return entity;
    }

    @Override
    public MessageDTO convertToModel(Message entity, MessageDTO model) {
        model.setId(entity.getId());
        model.setMessageKey(entity.getMessageKey());
        model.setMessageValue(entity.getMessageValue());
        return model;
    }
}
