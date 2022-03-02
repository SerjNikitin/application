package com.example.personsservice.repository;

import com.example.personsservice.entity.FamilyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyTypeRepository extends JpaRepository<FamilyType, Long> {
}
