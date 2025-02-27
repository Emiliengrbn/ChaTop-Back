package com.openclassrooms.services.interfaces;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.DTO.RegisterDTO;
import com.openclassrooms.DTO.TokenDTO;
import com.openclassrooms.DTO.UserDTO;

public interface IUserService {

    TokenDTO save(RegisterDTO registerDTO);
    TokenDTO login(UserDTO userDTO);
    MeDTO getUserByEmail(String email);
    MeDTO getUserById(Integer id);
}
