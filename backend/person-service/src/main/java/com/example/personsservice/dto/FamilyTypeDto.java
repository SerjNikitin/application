package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyTypeDto {
	private Long id;
	private String name;
	private String description;
	private Long classesCreatureId;
}
