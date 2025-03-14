package com.wil.library.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.wil.library.users.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    
    private static final String SECRET_KEY = "dasfas654das534f6sdzcv1x5z49asd86r4qw3e54w987eras35f4das6e87qwesad";

    public String getToken(User user) {
        return Jwts.builder()
        .setSubject("admin")
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    private Key getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }

}
