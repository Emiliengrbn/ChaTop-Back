package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.MessageDTO;
import com.openclassrooms.repository.DBMessagesRepository;
import com.openclassrooms.services.interfaces.IMessagesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MessagesController {

    @Autowired
    DBMessagesRepository dbMessagesRepository;

    @Autowired
    public IMessagesService messagesService;

    @PostMapping("/messages")
    public MessageResponseDTO messages(@Valid @RequestBody MessageDTO messageDTO) {
        return this.messagesService.send(messageDTO);
    }

}
