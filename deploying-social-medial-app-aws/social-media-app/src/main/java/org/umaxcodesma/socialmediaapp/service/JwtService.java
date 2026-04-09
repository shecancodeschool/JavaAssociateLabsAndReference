package org.umaxcodesma.socialmediaapp.service;

import io.jsonwebtoken.Claims;

public interface JwtService {

    String generateToken(String username);

    Claims validateToken(String token);

}
