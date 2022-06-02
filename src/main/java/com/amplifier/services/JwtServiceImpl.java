package com.amplifier.services;

import java.io.IOException;
import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amplifier.models.User;
import com.amplifier.models.UserJwtDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl {
    private Key key;

    public JwtServiceImpl() {
        byte[] secret = "my_secret_passwordafdsalkj;lkvjasd;lkfoijeowiru324u02938098134lkhj;ldjfa;sldkjfDSFSLDKJFLSKJF"
                .getBytes();
        key = Keys.hmacShaKeyFor(secret);
    }

    public String createJwt(User user) throws InvalidKeyException, JsonProcessingException {

        // 1. Turn user into userJwtDTO
        UserJwtDTO dto = new UserJwtDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getBattleTag(),
                user.getSocialMedia(),
                user.getJoinDate(),
                user.getUserRole(),
                user.isActive());

        // 2. Create a JWT with our dto (HERE!!!!!!!!!!)
        String jwt = Jwts.builder()
                .claim("user_dto", new ObjectMapper().writeValueAsString(dto))
                .signWith(key)
                .compact();

        // 3. Return the new JWT
        return jwt;
    }

    public UserJwtDTO parseJwt(String jwt) throws IOException, JsonProcessingException {

        // 1. Generate the token using claims from the jwt and our secret key
        Jws<Claims> token = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);

        // 2. Parse the token into a string
        String dtoString = (String) token.getBody().get("user_dto");

        // 3. Send the data to the client as json
        return (new ObjectMapper()).readValue(dtoString, UserJwtDTO.class);
    }
}
