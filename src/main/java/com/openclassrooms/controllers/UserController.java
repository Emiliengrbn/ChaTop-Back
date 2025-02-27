package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public IUserService userService;

    @GetMapping("/api/user/{id}")
    public MeDTO getUser(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }
}
