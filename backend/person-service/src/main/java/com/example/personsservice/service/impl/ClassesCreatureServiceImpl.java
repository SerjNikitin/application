package com.example.personsservice.service.impl;

import com.example.personsservice.entity.ClassesCreature;
import com.example.personsservice.repository.ClassesCreatureRepository;
import com.example.personsservice.service.ClassesCreatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassesCreatureServiceImpl implements ClassesCreatureService {
	private final ClassesCreatureRepository classesCreatureRepository;

	@Override
	public Optional<ClassesCreature> findById(Long id) {
		return classesCreatureRepository.findById(id);
	}

	@Override
	public List<ClassesCreature> findAll() {
		return classesCreatureRepository.findAll();
	}

	@Override
	@Transactional
	public ClassesCreature saveClassesCreature(ClassesCreature classesCreature) {
		return classesCreatureRepository.save(classesCreature);
	}
}
