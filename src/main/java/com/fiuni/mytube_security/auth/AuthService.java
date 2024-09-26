package com.fiuni.mytube_security.auth;

import com.fiuni.mytube.domain.user.UserDomain;
import com.fiuni.mytube_security.api.dao.user.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.fiuni.mytube_security.jwt.JwtService;

import com.fiuni.mytube_security.api.dao.user.IUserDao;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

        @Autowired
        private IUserDao userDao;
        @Autowired
        private IRoleDao roleDao;
        @Autowired
        private JwtService jwtService;
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                                                request.getPassword()));
                UserDetails user = userDao.findByEmail(request.getEmail()).orElseThrow();
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .build();

        }

        public AuthResponse register(RegisterRequest request) {
                // Crear el usuario
                UserDomain user = new UserDomain();
                user.setUsername(request.getUsername());
                user.setEmail(request.getEmail());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setRole(roleDao.findByName("Regular").orElse(null));
                user.setDeleted(false);
                user.setRegistrationDate(new Date());

                // Guardar el usuario
                userDao.save(user);

                // Crear la respuesta
                AuthResponse authResponse = new AuthResponse();
                authResponse.setToken(jwtService.getToken(user));

                return authResponse;
        }


}
