package com.example.personsservice.controller;

import com.example.personsservice.dto.ClassesCreatureDto;
import com.example.personsservice.entity.ClassesCreature;
import com.example.personsservice.mapper.PersonMapper;
import com.example.personsservice.massage.ResponseMassage;
import com.example.personsservice.service.ClassesCreatureService;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classes-creature")
public class ClassesCreatureController {
	private final ClassesCreatureService classesCreatureService;
	private final PersonMapper personMapper;

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getClassesCreature(@PathVariable Long id) {
		Optional<ClassesCreature> optionalClassesCreature = classesCreatureService.findById(id);
		if (optionalClassesCreature.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toClassesCreatureDto(optionalClassesCreature.get()));
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(ResponseMassage.NOT_FOUND_CLASSES_CREATURE, id));
	}

	@GetMapping("/get-all")
	public ResponseEntity<?> getClassesCreatures() {
		List<ClassesCreature> classesCreatures = classesCreatureService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(personMapper.toListClassesCreatureDto(classesCreatures));
	}

	@PostMapping("/create")
	public ResponseEntity<?> createClassesCreature(@RequestBody ClassesCreatureDto classesCreatureDto) {
		try {
			ClassesCreature classesCreature = classesCreatureService.saveClassesCreature(personMapper.toClassesCreature(classesCreatureDto));
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toClassesCreatureDto(classesCreature));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseMassage.SOMETHING_WENT_WRONG);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateClassesCreature(@PathVariable Long id, @RequestBody ClassesCreatureDto classesCreatureDto) {
		Optional<ClassesCreature> optionalClassesCreature = classesCreatureService.findById(id);
		if (optionalClassesCreature.isPresent()) {
			ClassesCreature classesCreature = classesCreatureService.saveClassesCreature(personMapper.toClassesCreature(classesCreatureDto));
			return ResponseEntity.status(HttpStatus.OK).body(personMapper.toClassesCreatureDto(classesCreature));
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(ResponseMassage.NOT_FOUND_CLASSES_CREATURE, id));
	}

}
