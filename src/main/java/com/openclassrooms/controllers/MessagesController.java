package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.MessageDTO;
import com.openclassrooms.repository.DBMessagesRepository;
import com.openclassrooms.services.interfaces.IMessagesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessagesController {

    @Autowired
    public IMessagesService messagesService;

    @PostMapping("/messages")
    @Operation(summary = "Send Message", description = "Send a new message and receive a response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public MessageResponseDTO messages(@Valid @RequestBody MessageDTO messageDTO) {
        return this.messagesService.send(messageDTO);
    }

}
