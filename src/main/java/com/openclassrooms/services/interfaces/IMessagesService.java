package com.openclassrooms.services.interfaces;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.MessageDTO;

public interface IMessagesService {

    MessageResponseDTO send(MessageDTO messageDTO);
}
