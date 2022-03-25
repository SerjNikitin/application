package com.example.personsservice.controller;


import com.example.personsservice.dto.ClassesCreatureDto;
import com.example.personsservice.dto.FamilyTypeDto;
import com.example.personsservice.entity.ClassesCreature;
import com.example.personsservice.entity.FamilyType;
import com.example.personsservice.mapper.PersonMapper;
import com.example.personsservice.massage.ResponseMassage;
import com.example.personsservice.service.FamilyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/family-type")
public class FamilyTypeController {
	private final FamilyTypeService familyTypeService;
	private final PersonMapper personMapper;

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getFamilyType(@PathVariable Long id) {
		Optional<FamilyType> optionalFamilyType = familyTypeService.findById(id);
		if (optionalFamilyType.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toFamilyTypeDto(optionalFamilyType.get()));
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(ResponseMassage.NOT_FOUND_FAMILY_TYPE, id));
	}

	@GetMapping("/get-all")
	public ResponseEntity<?> getFamilyTypes() {
		List<FamilyType> familyTypes = familyTypeService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(personMapper.toListFamilyTypeDtos(familyTypes));
	}

	@PostMapping("/create")
	public ResponseEntity<?> createFamilyType(@RequestBody @Valid FamilyTypeDto familyTypeDto) {
		try {
			FamilyType familyType = familyTypeService.saveFamilyType(personMapper.toFamilyType(familyTypeDto));
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toFamilyTypeDto(familyType));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseMassage.SOMETHING_WENT_WRONG);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateFamilyType(@PathVariable Long id, @RequestBody @Valid FamilyTypeDto familyTypeDto) {

		Optional<FamilyType> optionalFamilyType = familyTypeService.findById(id);
		if (optionalFamilyType.isPresent()) {
			FamilyType familyType = familyTypeService.saveFamilyType(personMapper.toFamilyType(familyTypeDto));
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toFamilyTypeDto(familyType));
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(ResponseMassage.NOT_FOUND_FAMILY_TYPE, id));
	}
}