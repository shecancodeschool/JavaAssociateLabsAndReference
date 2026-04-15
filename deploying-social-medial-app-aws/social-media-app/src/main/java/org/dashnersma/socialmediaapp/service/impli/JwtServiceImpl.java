package org.umaxcodesma.socialmediaapp.service.impli;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.umaxcodesma.socialmediaapp.domain.enums.Role;
import org.umaxcodesma.socialmediaapp.service.JwtService;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${application.jwt.secretKey}")
    private String secretKey;

    @Override
    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .claim("role", Role.USER)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 minutes
                .signWith(getSignInKey())
                .compact();
    }

    @Override
    public Claims validateToken(String token) {

        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
