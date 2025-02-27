package com.openclassrooms.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RentalPictureDTO extends RentalDTO{

    public String picture;

    @JsonProperty("created_at")
    public Date createdAt;

    @JsonProperty("updated_at")
    public Date updatedAt;
}
