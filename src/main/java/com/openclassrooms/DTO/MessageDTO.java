package com.openclassrooms.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MessageDTO {

    private Integer id;
    @NotNull
    @Column(name = "rental_id")
    @JsonProperty("rental_id")
    private Integer rentalId;
    @NotNull
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private Integer userId;
    @NotNull
    @NotEmpty(message = "message can't be empty")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
