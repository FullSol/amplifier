package com.amplifier.services;

import java.io.IOException;
import java.security.InvalidKeyException;

import com.amplifier.models.User;
import com.amplifier.models.UserJwtDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface JwtService {
    public String createJwt(User user) throws InvalidKeyException, JsonProcessingException;

    public UserJwtDTO getDTO(String jwt);

    public UserJwtDTO parseJwt(String jwt) throws IOException, JsonProcessingException;
}
