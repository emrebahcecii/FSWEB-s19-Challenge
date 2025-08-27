package com.example.FSWEB_s19_challenge.repository;

import com.example.FSWEB_s19_challenge.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.email = :email")
    Optional<AppUser> findUserByEmail(String email);
}
