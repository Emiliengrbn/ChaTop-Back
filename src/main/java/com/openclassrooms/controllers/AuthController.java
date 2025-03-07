package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.DTO.RegisterDTO;
import com.openclassrooms.DTO.TokenDTO;
import com.openclassrooms.DTO.UserDTO;
import com.openclassrooms.services.JWTService;
import com.openclassrooms.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public JWTService jwtService;

    @Autowired
    public IUserService userService;

    public AuthController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate a user and return a JWT token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TokenDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public TokenDTO login(@RequestBody @Validated UserDTO userDTO) {
        return this.userService.login(userDTO);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "User Registration", description = "Register a new user and return a JWT token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TokenDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content)
    })
    public TokenDTO register(@RequestBody @Validated RegisterDTO registerDTO) {
        return this.userService.save(registerDTO);
    }

    @GetMapping("/me")
    @Operation(summary = "Get User Info", description = "Retrieve the authenticated user's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User details retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MeDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public MeDTO getUser(Principal principal) {
        final String email = principal.getName();
        return this.userService.getUserByEmail(email);
    }
}
