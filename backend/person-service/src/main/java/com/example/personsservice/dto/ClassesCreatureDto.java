package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ClassesCreatureDto {
	private Long id;
	@NotEmpty(message = "Название для класса персонажа не может быть пустым")
	private String name;
	private String description;
	@NotNull
	private Long sideId;
	private List<FamilyTypeDto> familyTypes;
}