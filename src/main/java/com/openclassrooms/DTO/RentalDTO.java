package com.openclassrooms.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class RentalDTO {

	private Integer id;
	@NotEmpty(message = "Y")
	@NotNull(message = "T")
    private String name;
	@NotNull(message = "R")
    private Double surface;
	@NotNull(message = "E")
    private Double price;
	@NotEmpty(message = "Z")
	@NotNull(message = "A")
    private String description;
    @JsonProperty("owner_id")
    private Integer ownerId;

	public RentalDTO() {
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSurface() {
		return surface;
	}
	
	public void setSurface(Double surface) {
		this.surface = surface;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

    
}
