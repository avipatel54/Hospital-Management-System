package com.hospital.patient_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenService {
    private String secret="aaravkassssssssssssssssssssssssssssssssjdgfjdngjdngkdjdlflf";

    private KeyPair keyPair;

    public JwtTokenService() throws NoSuchAlgorithmException {
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
        return Jwts.parser()
                .setSigningKey(keyPair.getPublic())
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
