package com.openclassrooms.controllers;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.RentalMultipartFileDTO;
import com.openclassrooms.DTO.RentalPictureDTO;
import com.openclassrooms.DTO.RentalResponseDTO;
import com.openclassrooms.services.interfaces.IRentalsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
    
    @Autowired
    public IRentalsService rentalService;

    @PostMapping
    @Operation(summary = "Post rental", description = "Create a rental")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rental created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public MessageResponseDTO createRental(@ModelAttribute @Validated RentalMultipartFileDTO rentalsDTO, Principal principal) throws IOException {
        return rentalService.create(rentalsDTO, principal.getName());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Put rental", description = "Modify a specific rental")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rental modified successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public MessageResponseDTO updateRental(@ModelAttribute @PathVariable Integer id, RentalMultipartFileDTO rentalsDTO, Principal principal) throws IOException {
        return rentalService.update(id, rentalsDTO, principal.getName());
    }

    @GetMapping
    @Operation(summary = "Get rentals", description = "Returns all rentals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rentals retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RentalResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public RentalResponseDTO getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rental", description = "Returns a specific rental")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rental retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RentalPictureDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    public RentalPictureDTO getRentalById(@PathVariable Integer id) {
        return rentalService.getRentalById(id);
    }
}
