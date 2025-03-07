package com.openclassrooms.services;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.MessageDTO;
import com.openclassrooms.model.DBMessages;
import com.openclassrooms.repository.DBMessagesRepository;
import com.openclassrooms.services.interfaces.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService implements IMessagesService {

    @Autowired
    private DBMessagesRepository messageRepository;

    @Override
    public MessageResponseDTO send( MessageDTO messageDTO) {
        DBMessages message = new DBMessages();
        message.setMessage(messageDTO.getMessage());
        message.setUserId(messageDTO.getUserId());

        message.setRentalId(messageDTO.getRentalId());

        messageRepository.save(message);

        return new MessageResponseDTO("Message send with success");
    }
}
