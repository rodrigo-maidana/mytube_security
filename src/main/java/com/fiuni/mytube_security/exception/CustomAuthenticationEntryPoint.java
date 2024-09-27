package com.fiuni.mytube_security.exception;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        try {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Acceso denegado: Se requiere autenticación.");
        } catch (IOException e) {
            e.printStackTrace(); // Manejo simple del IOException
        }
    }
}
