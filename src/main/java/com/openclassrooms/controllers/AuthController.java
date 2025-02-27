package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.DTO.RegisterDTO;
import com.openclassrooms.DTO.TokenDTO;
import com.openclassrooms.DTO.UserDTO;
import com.openclassrooms.services.JWTService;
import com.openclassrooms.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public JWTService jwtService;

    public UserDTO user;

    @Autowired
    public IUserService userService;

    public AuthController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody @Validated UserDTO userDTO) {
        return this.userService.login(userDTO);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenDTO register(@RequestBody @Validated RegisterDTO registerDTO) {
        return this.userService.save(registerDTO);
    }

    @GetMapping("/me")
    public MeDTO getUser(Principal principal) {
        final String email = principal.getName();
        return this.userService.getUserByEmail(email);
    }
}
