package com.openclassrooms.services.interfaces;

import com.openclassrooms.DTO.MessageResponseDTO;
import com.openclassrooms.DTO.RentalMultipartFileDTO;
import com.openclassrooms.DTO.RentalResponseDTO;
import com.openclassrooms.model.DBRentals;

import java.io.IOException;

public interface IRentalsService {

	MessageResponseDTO create(RentalMultipartFileDTO rentalsDTO, String email) throws IOException;
	MessageResponseDTO update(Integer id, RentalMultipartFileDTO rentalsDTO, String email) throws IOException;
	DBRentals getRentalById(Integer id);
	RentalResponseDTO getAllRentals();
}
