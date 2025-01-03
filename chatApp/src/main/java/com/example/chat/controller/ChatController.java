package com.example.chat.controller;

import com.example.chat.model.Message;
import com.example.chat.service.MessageS;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageS messageService;
    public ChatController(SimpMessagingTemplate messagingTemplate, MessageS messageS) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageS;
    }


    @MessageMapping("/sendMessage")
    public void sendMessage( Message message) {
        message.setTime(LocalDateTime.now().toString());
        messageService.saveMessage(message);
        if("GROUP".equals(message.getType())) {
            messagingTemplate.convertAndSend("/topic/group", message);

        } else if("PRIVATE".equals(message.getType())) {
            messagingTemplate.convertAndSend(
                    "/queue/"+message.getRecipient(),
                    message
            );
        }
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}