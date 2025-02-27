package com.openclassrooms.services;

import com.openclassrooms.DTO.MeDTO;
import com.openclassrooms.DTO.RegisterDTO;
import com.openclassrooms.DTO.TokenDTO;
import com.openclassrooms.DTO.UserDTO;
import com.openclassrooms.model.DBUser;
import com.openclassrooms.repository.DBUserRepository;
import com.openclassrooms.services.interfaces.IJWTService;
import com.openclassrooms.services.interfaces.IUserService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    public IJWTService jwtService;

    @Autowired
    private DBUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDTO save(RegisterDTO registerDTO) {
        DBUser user = new DBUser();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        String hashedPassword = passwordEncoder.encode(registerDTO.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        final String token = jwtService.generateToken(registerDTO.getEmail());
        return new TokenDTO(token);
    }

    @Override
    public TokenDTO login(UserDTO userDTO) {
    	DBUser user = userRepository.findByEmail(userDTO.getEmail());
        boolean passwordMatches = passwordEncoder.matches(userDTO.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException();
        }
        final String token = jwtService.generateToken(user.getEmail());
        return new TokenDTO(token);
    }

    @Override
    public MeDTO getUserByEmail(String email){
        DBUser user = userRepository.findByEmail(email);
        MeDTO me = new MeDTO();
        me.setEmail(user.getEmail());
        me.setId(user.getId());
        me.setName(user.getName());
        me.setCreatedAt(user.getCreatedAt());
        me.setUpdatedAt(user.getUpdatedAt());
        return me;
    }

    @Override
    public MeDTO getUserById(Integer id) {
        DBUser user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + id));

        MeDTO me = new MeDTO();
        me.setEmail(user.getEmail());
        me.setId(user.getId());
        me.setName(user.getName());
        me.setCreatedAt(user.getCreatedAt());
        me.setUpdatedAt(user.getUpdatedAt());

        return me;
    }
}
