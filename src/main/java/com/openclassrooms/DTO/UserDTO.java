package com.openclassrooms.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @Email(message = "Error")
    @NotNull(message = "Error")
    @NotEmpty(message = "Error")
    private String email;
    @NotEmpty(message = "Error")
    @NotNull(message = "Error")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
