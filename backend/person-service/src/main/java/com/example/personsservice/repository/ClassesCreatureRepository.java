package com.example.personsservice.repository;

import com.example.personsservice.entity.ClassesCreature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesCreatureRepository extends JpaRepository<ClassesCreature, Long> {
}
