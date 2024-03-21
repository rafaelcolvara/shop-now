package com.shopnow.userms.conf;

import com.shopnow.userms.entity.User;
import com.shopnow.userms.repo.RepositoryUser;
import com.shopnow.userms.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private RepositoryUser usuarioJPA;

    public AuthTokenFilter(TokenService tokenService, RepositoryUser usuarioJPA){
        this.tokenService = tokenService;
        this.usuarioJPA = usuarioJPA;
    }

    public AuthTokenFilter() {

    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);

        boolean valido = tokenService.isTokenValido(token);
        if (valido) {
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {

        String username = tokenService.getUsernameToken(token);
        User usuario = usuarioJPA.findByUsername(username).get();
        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(usuario.getUsername(), null, usuario.getAuthorities());
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
