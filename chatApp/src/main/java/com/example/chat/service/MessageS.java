package com.example.chat.service;

import com.example.chat.model.Message;
import com.example.chat.repository.MessageR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageS {
    private MessageR messageR;
    MessageS(MessageR messageR) {
        this.messageR = messageR;
    }
    public Message saveMessage(Message message){
        return messageR.save(message);
    }

}
