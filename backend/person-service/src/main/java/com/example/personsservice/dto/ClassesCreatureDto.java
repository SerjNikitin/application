package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassesCreatureDto {
	private Long id;
	private String name;
	private String description;
	private Long sideId;
	private List<FamilyTypeDto> familyTypes;
}