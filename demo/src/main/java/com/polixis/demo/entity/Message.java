package com.polixis.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "messageKey")
    private String messageKey;

    @Column(name = "messageValue")
    private String messageValue;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageKey='" + messageKey + '\'' +
                ", messageValue='" + messageValue + '\'' +
                '}';
    }
}
