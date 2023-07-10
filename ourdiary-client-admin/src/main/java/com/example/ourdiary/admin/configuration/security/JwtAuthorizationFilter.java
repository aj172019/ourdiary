package com.example.ourdiary.admin.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Value("${ourdiary.system-allowed-authorities}")
    private List<String> allowedAuthorities;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            List<String> grantedAuthorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            if (isAllowed(grantedAuthorities)) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new ServletException("Unauthorized access");
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean isAllowed(List<String> grantedAuthorities) {
        return allowedAuthorities.stream().anyMatch(grantedAuthorities::contains);
    }
}
