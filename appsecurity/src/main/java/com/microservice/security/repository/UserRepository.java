package com.microservice.security.repository;

import com.microservice.security.model.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetailEntity, Long> {

    Optional<UserDetailEntity> findByUserName(String userName);
}
