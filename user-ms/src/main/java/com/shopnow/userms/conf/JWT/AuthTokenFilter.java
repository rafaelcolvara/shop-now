package com.shopnow.userms.conf.JWT;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.repo.RepositoryUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RepositoryUser usuarioJPA;

    public AuthTokenFilter(TokenService tokenService, RepositoryUser usuarioJPA){
        this.tokenService = tokenService;
        this.usuarioJPA = usuarioJPA;
    }

    private List<String> allowedPaths = Arrays.asList("/user/login", "/user/refresh","/user/save");
    public AuthTokenFilter() {

    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean isLoginRequest = allowedPaths.stream().anyMatch(path -> request.getRequestURI().contains(path));
        boolean isTokenValid = !Objects.isNull(token) && tokenService.isTokenValido(token);

        if (!isLoginRequest && isTokenValid) {
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {

        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(tokenService.getUsernameToken(token), null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token==null || token.isEmpty() || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7, token.length());

    }
}
