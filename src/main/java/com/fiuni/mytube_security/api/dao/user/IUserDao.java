package com.fiuni.mytube_security.api.dao.user;

import com.fiuni.mytube.domain.user.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDao extends JpaRepository<UserDomain, Integer> {
    Optional<UserDomain> findByEmail(String email);
    // Métodos adicionales si es necesario
}
