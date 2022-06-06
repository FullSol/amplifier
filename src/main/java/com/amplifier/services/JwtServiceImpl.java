package com.amplifier.services;

import java.io.IOException;
import java.security.Key;

import org.apache.log4j.Logger;
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
public class JwtServiceImpl implements JwtService {
    private Key key;
    private static Logger logger = Logger.getLogger(JwtServiceImpl.class);

    public JwtServiceImpl() {
        byte[] secret = "my_secret_passwordafdsalkj;lkvjasd;lkfoijeowiru324u02938098134lkhj;ldjfa;sldkjfDSFSLDKJFLSKJF"
                .getBytes();
        key = Keys.hmacShaKeyFor(secret);
    }

    @Override
    public String createJwt(User user) throws InvalidKeyException, JsonProcessingException {
        logger.debug(user.toString());
        // 1. Turn user into userJwtDTO
        UserJwtDTO dto = new UserJwtDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getBattleTag(),
                user.getSocialMedia(),
                user.getUserRole(),
                user.isActive());
        logger.debug(dto.toString());

        // 2. Create a JWT with our dto (HERE!!!!!!!!!!)
        String jwt = Jwts.builder()
                .claim("user_dto", new ObjectMapper().writeValueAsString(dto))
                .signWith(key)
                .compact();

        // 3. Return the new JWT
        return jwt;
    }

    @Override
    public UserJwtDTO getDTO(String jwt) {
        UserJwtDTO dto = new UserJwtDTO();

        try {
            dto = this.parseJwt(jwt);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public UserJwtDTO parseJwt(String jwt) throws IOException, JsonProcessingException {

        // 1. Generate the token using claims from the jwt and our secret key
        Jws<Claims> token = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);

        // 2. Parse the token into a string
        String dtoString = (String) token.getBody().get("user_dto");

        // 3. Send the data to the client as json
        return (new ObjectMapper()).readValue(dtoString, UserJwtDTO.class);
    }
}
