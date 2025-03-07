package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public IUserService userService;

    @GetMapping("/api/user/{id}")
    @Operation(summary = "Get User by ID", description = "Retrieve user details based on the provided user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User details retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MeDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid user ID format", content = @Content)
    })
    public MeDTO getUser(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }
}
