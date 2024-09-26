package com.fiuni.mytube_security.api.dao.user;

import com.fiuni.mytube.domain.user.RoleDomain;
import com.fiuni.mytube.domain.user.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleDao extends JpaRepository<RoleDomain, Integer> {
    // findbyname
    Optional<RoleDomain> findByName(String name);
}
