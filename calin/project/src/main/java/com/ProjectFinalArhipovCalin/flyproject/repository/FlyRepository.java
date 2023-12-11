package com.ProjectFinalArhipovCalin.flyproject.repository;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.Fly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends JpaRepository<Fly, Integer> {
}
