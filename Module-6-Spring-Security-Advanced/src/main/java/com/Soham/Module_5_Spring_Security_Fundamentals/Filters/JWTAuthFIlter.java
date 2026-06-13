package com.Soham.Module_5_Spring_Security_Fundamentals.Filters;

import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.JWTSerivce;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthFIlter extends OncePerRequestFilter {

    private final JWTSerivce jwtSerivce;
    private final UserService userService;
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver exceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            final String requestTokenHeader = request.getHeader("Authorization");
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = requestTokenHeader.substring(7).trim();
            Long userId = jwtSerivce.getUserIdFromToken(token);

            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userService.getUseryId(userId);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
            filterChain.doFilter(request, response);


        } catch (Exception e) {
            exceptionResolver.resolveException(request,response,null,e);
        }
    }

}
