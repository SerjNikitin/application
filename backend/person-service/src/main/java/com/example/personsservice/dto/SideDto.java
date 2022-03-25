package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class SideDto {
	private Long id;
	@NotEmpty(message = "Название для стороны не может быть пустым")
	private String name;
	private String description;
	private List<ClassesCreatureDto> classesCreatures;
}
