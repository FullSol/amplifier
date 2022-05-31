package com.amplifier.services;

import java.io.IOException;
import java.security.Key;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amplifier.models.User;
import com.amplifier.models.UserJwtDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

public class JwtServiceImpl implements JwtService {
    private Key key;

    public JwtServiceImpl() {
        // You will need a SECRET KEY to create the token, I would recommend to store
        // it inside a .env file. For this example though, I will store it a variable.
        byte[] secret = "my_secret_passwordafdsalkj;lkvjasd;lkfoijeowiru324u02938098134lkhj;ldjfa;sldkjfDSFSLDKJFLSKJF"
                .getBytes();
        key = Keys.hmacShaKeyFor(secret);
    }

    public String createJwt(User user) throws InvalidKeyException, JsonProcessingException {
        UserJwtDTO dto = new UserJwtDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(),
                user.getRole());

        String jwt = Jwts.builder()
                .claim("user_dto", new ObjectMapper().writeValueAsString(dto))
                .signWith(key)
                .compact();

        return jwt;
    }

    public UserJwtDTO parseJwt(String jwt) throws IOException, JsonProcessingException {
        // 1. Generate the token using claims from the jwt and our secret key
        // claims = pieces of information asserted about a subject from a token
        Jws<Claims> token = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);

        // 2. parse the token into a string
        String dtoString = (String) token.getBody().get("user_dto");

        // 3. send the data to the client as json
        return (new ObjectMapper()).readValue(dtoString, UserJwtDTO.class);
    }
}
