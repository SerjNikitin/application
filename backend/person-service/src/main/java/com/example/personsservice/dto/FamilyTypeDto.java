package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FamilyTypeDto {
	private Long id;
	@NotEmpty(message = "Название для типа семьи не может быть пустым")
	private String name;
	private String description;
	@NotNull
	private Long classesCreatureId;
}
