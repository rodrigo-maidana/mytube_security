package com.fiuni.mytube_security.api.dao.user;

import com.fiuni.mytube.domain.profile.ProfileDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfileDao extends JpaRepository<ProfileDomain, Integer> {
    Optional<ProfileDomain> findByUserId(Integer userId);
}
