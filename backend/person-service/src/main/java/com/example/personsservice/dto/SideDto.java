package com.example.personsservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SideDto {
	private Long id;
	private String name;
	private String description;
	private List<ClassesCreatureDto> classesCreatures;
}
