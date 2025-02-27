package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.RentalMultipartFileDTO;
import com.openclassrooms.DTO.RentalResponseDTO;
import com.openclassrooms.model.DBRentals;
import com.openclassrooms.services.interfaces.IRentalsService;

import com.openclassrooms.services.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
    
    @Autowired
    public IRentalsService rentalService;

    @Autowired
    private IS3Service s3Service;

    private List<DBRentals> rentals = new ArrayList<>();

    @PostMapping
    public MessageResponseDTO createRental(@ModelAttribute @Validated RentalMultipartFileDTO rentalsDTO, Principal principal) throws IOException {
        System.out.println(rentalsDTO);
            return rentalService.create(rentalsDTO, principal.getName());
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateRental(@ModelAttribute @PathVariable Integer id, RentalMultipartFileDTO rentalsDTO, Principal principal) throws IOException {
        return rentalService.update(id, rentalsDTO, principal.getName());
    }

    @GetMapping
    public RentalResponseDTO getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public DBRentals getRentalById(@PathVariable Integer id) {
        return rentalService.getRentalById(id);
    }
}
