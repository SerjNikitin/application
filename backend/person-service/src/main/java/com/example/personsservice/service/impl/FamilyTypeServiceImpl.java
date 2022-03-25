package com.example.personsservice.service.impl;

import com.example.personsservice.entity.FamilyType;
import com.example.personsservice.repository.FamilyTypeRepository;
import com.example.personsservice.service.FamilyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FamilyTypeServiceImpl implements FamilyTypeService {
	private final FamilyTypeRepository familyTypeRepository;

	@Override
	public Optional<FamilyType> findById(Long id) {
		return familyTypeRepository.findById(id);
	}

	@Override
	public List<FamilyType> findAll() {
		return familyTypeRepository.findAll();
	}

	@Override
	@Transactional
	public FamilyType saveFamilyType(FamilyType familyType) {
		return familyTypeRepository.save(familyType);
	}
}