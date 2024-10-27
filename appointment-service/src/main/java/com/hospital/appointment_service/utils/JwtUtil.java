package com.hospital.appointment_service.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String secret="aarav";

    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public String extractUserName(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
    public boolean isTokenExprired(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJwt(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
    public boolean validateToken(String token,String userName){
        String userNameFromToken=extractUserName(token);
        return userNameFromToken.equals(userName) && !isTokenExprired(token);
    }
}
