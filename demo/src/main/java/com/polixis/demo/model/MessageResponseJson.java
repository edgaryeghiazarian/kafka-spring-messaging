package com.polixis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponseJson {
    private String key;
    private String message;
}
