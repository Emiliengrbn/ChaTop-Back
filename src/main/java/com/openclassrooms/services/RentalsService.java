package com.openclassrooms.services;

import com.openclassrooms.DTO.*;
import com.openclassrooms.services.interfaces.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.openclassrooms.model.DBRentals;
import com.openclassrooms.repository.DBRentalsRepository;
import com.openclassrooms.services.interfaces.IRentalsService;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class RentalsService implements IRentalsService{
	
	@Autowired
	private DBRentalsRepository rentalRepository;

	@Autowired
	private S3Service s3Service;

	@Autowired
	public IUserService userService;

	@Autowired
	public ModelMapper modelMapper;
	
	public MessageResponseDTO create(RentalMultipartFileDTO rentalsDTO, String email) throws IOException {
		DBRentals rental = new DBRentals();
		rental.setName(rentalsDTO.getName());
		rental.setSurface(rentalsDTO.getSurface());
		rental.setPrice(rentalsDTO.getPrice());
		rental.setDescription(rentalsDTO.getDescription());

		MeDTO user = this.userService.getUserByEmail(email);

		rental.setOwnerId(user.getId());
		final String pictureUrl = s3Service.uploadFile(rentalsDTO.getPicture());
		rental.setPicture(pictureUrl);
        rentalRepository.save(rental);
		return new MessageResponseDTO("rental created");
	}

	public MessageResponseDTO update(Integer id, RentalMultipartFileDTO rentalsDTO, String email) throws IOException {
		DBRentals rental = rentalRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Location non trouvé avec l'ID : " + id));

		MeDTO user = this.userService.getUserByEmail(email);
		if (!rental.getOwnerId().equals(user.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

        rental.setName(rentalsDTO.getName());
        rental.setPrice(rentalsDTO.getPrice());
        rental.setSurface(rentalsDTO.getSurface());
        rental.setDescription(rentalsDTO.getDescription());

		rentalRepository.save(rental);

		return new MessageResponseDTO("Rental updated !");
	}

	public DBRentals getRentalById(Integer id) {
		DBRentals rental = rentalRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Location non trouvé avec l'ID : " + id));

		return rental;
	}

	@Override
	public RentalResponseDTO getAllRentals() {
		List<DBRentals> rentals = this.rentalRepository.findAll();
		List<RentalPictureDTO> rentalPictureDTOS = rentals.stream().map(rental -> this.modelMapper.map(rental, RentalPictureDTO.class)).toList();
		RentalResponseDTO response = new RentalResponseDTO();
		response.rentals = rentalPictureDTOS;
		return response;
	}

}
