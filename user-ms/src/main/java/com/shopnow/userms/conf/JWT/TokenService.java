package com.shopnow.userms.conf.JWT;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.entity.dto.LoginRequestDTO;
import com.shopnow.userms.entity.dto.ResponseLoginDTO;
import com.shopnow.userms.repo.RepositoryUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.image.PixelGrabber;
import java.util.Date;

@Service
public class TokenService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RepositoryUser usuarioJPA;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String tempoExpiracao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


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

    public String gerarReToken(Authentication authentication){


        Date hoje = new Date();
        Date expiracao = new Date(hoje.getTime() + Long.parseLong(tempoExpiracao));
        return "Bearer " + Jwts.builder().setIssuer("API do Login")
                .setSubject(authentication.getPrincipal().toString())
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS512, secret )
                .compact();

    }

    public ResponseEntity<?> refreshToken(String token){
        if(isTokenValido(token)){
            String username = getUsernameToken(token);
            User user =  usuarioJPA.findByUsername(username).get();
            if (user != null) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(username, user.getPassword());
                if (user.getPassword()== authentication.getCredentials().toString()) {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseLoginDTO(gerarReToken(authentication), "RE-TOKEN", username ));
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token is invalid or expired.");
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