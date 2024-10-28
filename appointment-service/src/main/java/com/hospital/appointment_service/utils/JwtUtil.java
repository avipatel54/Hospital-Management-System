package com.hospital.appointment_service.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Component
public class JwtUtil {
    private String secret="aaravkassssssssssssssssssssssssssssssssjdgfjdngjdngkdjdlflf";

    private KeyPair keyPair;

    public JwtUtil() throws NoSuchAlgorithmException {
        // Generate EC key pair programmatically (for ES256)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256); // Using P-256 curve for ES256
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.ES256,keyPair.getPrivate())
                .compact();
    }
    public String extractUserName(String token){
         Claims claims=Jwts.parser()
                .setSigningKey(keyPair.getPublic())
                .parseClaimsJws(token)
                .getBody();
         return claims.getSubject();
    }
    public boolean isTokenExprired(String token){
        return Jwts.parser()
                .setSigningKey(keyPair.getPublic())
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
    public boolean validateToken(String token,String userName){
        String userNameFromToken=extractUserName(token);
        return userNameFromToken.equals(userName) && !isTokenExprired(token);
    }
}
