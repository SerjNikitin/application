package com.example.personsservice.service;

import com.example.personsservice.entity.FamilyType;

import java.util.List;
import java.util.Optional;

public interface FamilyTypeService {
	Optional<FamilyType> findById(Long id);

	List<FamilyType> findAll();

	FamilyType saveFamilyType(FamilyType familyType);
}
