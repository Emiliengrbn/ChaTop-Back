package com.openclassrooms.services.interfaces;

import org.springframework.security.oauth2.jwt.Jwt;

public interface IJWTService {

    String generateToken(final String email);
    Jwt claimsEmail(final String token);
}
