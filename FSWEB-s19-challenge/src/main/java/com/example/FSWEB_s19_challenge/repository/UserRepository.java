package com.example.FSWEB_s19_challenge.repository;

import com.example.FSWEB_s19_challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
