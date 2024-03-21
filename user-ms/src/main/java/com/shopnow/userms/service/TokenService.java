package com.shopnow.userms.service;

import com.shopnow.userms.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String tempoExpiracao;


    public String gerarToken(Authentication authentication){
        User userLogado = (User) authentication.getPrincipal();
        Date hoje = new Date();
        Date expiracao = new Date(hoje.getTime() + Long.parseLong(tempoExpiracao));
        return "Bearer " + Jwts.builder().setIssuer("API do Login")
                .setSubject(userLogado.getUsername())
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS512, secret )
                .compact();

    }

    public boolean isTokenValido(String token){

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getUsernameToken(String token) {

        io.jsonwebtoken.Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
}