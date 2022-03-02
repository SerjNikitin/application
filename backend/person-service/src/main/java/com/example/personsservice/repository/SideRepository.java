package com.example.personsservice.repository;

import com.example.personsservice.entity.Side;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideRepository extends JpaRepository<Side, Long> {
}
