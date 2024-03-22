package com.shopnow.productms.conf.JWT;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    private final TokenManager tokenManager;

    @Autowired
    public AuthTokenFilter(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean isTokenValid = !Objects.isNull(token) && isTokenValido(token);

        if (isTokenValid)
            autenticarCliente(token);
        else {
            throw new RuntimeException("Invalid Token");
        }
        filterChain.doFilter(request, response);
    }
    private void autenticarCliente(String token) {

        String username = this.getUsernameToken(token);
        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        tokenManager.setJwtToken(token);

    }
    public String getUsernameToken(String token) {

        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token==null || token.isEmpty() || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7, token.length());

    }
    public boolean isTokenValido(String token){

        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
