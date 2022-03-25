package com.example.personsservice.service.impl;

import com.example.personsservice.entity.ClassesCreature;
import com.example.personsservice.entity.Side;
import com.example.personsservice.repository.ClassesCreatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = ClassesCreatureServiceImpl.class)
//@AutoConfigureMockMvc

class ClassesCreatureServiceImplTest {
	private ClassesCreatureServiceImpl classesCreatureService;
	private ClassesCreature classesCreatureTest =
			new ClassesCreature(1L, "name1", "name2", new Side(), new ArrayList<>());

	@BeforeEach
	void setUp() {
		ClassesCreatureRepository mockRepository = Mockito.mock(ClassesCreatureRepository.class);
		classesCreatureService = new ClassesCreatureServiceImpl(mockRepository);
		Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(classesCreatureTest));
		Mockito.when(mockRepository.findAll()).thenReturn(List.of(classesCreatureTest));
	}

	@Test
	void findById() {
		Optional<ClassesCreature> classesCreatureOptional = classesCreatureService.findById(1L);
		assertTrue(classesCreatureOptional.isPresent());
		assertEquals(classesCreatureOptional.get(), classesCreatureTest);
	}

	@Test
	void findAll() {
		List<ClassesCreature> classesCreatures = classesCreatureService.findAll();
		assertEquals(1, classesCreatures.size());
		assertEquals(List.of(classesCreatureTest), classesCreatures);
	}

	@Test
	void saveClassesCreature() {
		Mockito.when(classesCreatureService.saveClassesCreature(classesCreatureTest)).thenReturn(classesCreatureTest);
	}
}