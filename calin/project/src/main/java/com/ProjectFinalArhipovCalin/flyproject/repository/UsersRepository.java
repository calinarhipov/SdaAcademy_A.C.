package com.ProjectFinalArhipovCalin.flyproject.repository;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//aceasta clasa poate fi injectata ca o dependinta, asta face @Service
@Repository
//@Component //poate fi injectat mai departe
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);

    }


