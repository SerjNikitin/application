package com.example.personsservice.service;

import com.example.personsservice.entity.ClassesCreature;

import java.util.List;
import java.util.Optional;

public interface ClassesCreatureService {
	Optional<ClassesCreature> findById(Long id);
	List<ClassesCreature> findAll();

	ClassesCreature saveClassesCreature(ClassesCreature classesCreature);
}
