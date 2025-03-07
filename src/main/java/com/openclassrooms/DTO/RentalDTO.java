package com.openclassrooms.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentalDTO {

	private Integer id;
	@NotEmpty()
	@NotNull()
    private String name;
	@NotNull()
    private Double surface;
	@NotNull()
    private Double price;
	@NotEmpty()
	@NotNull()
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
