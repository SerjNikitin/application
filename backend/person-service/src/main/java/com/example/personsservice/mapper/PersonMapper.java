package com.example.personsservice.mapper;

import com.example.personsservice.dto.ClassesCreatureDto;
import com.example.personsservice.dto.FamilyTypeDto;
import com.example.personsservice.dto.SideDto;
import com.example.personsservice.entity.ClassesCreature;
import com.example.personsservice.entity.FamilyType;
import com.example.personsservice.entity.Side;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	@Mapping(source = "sideId", target = "side.id")
	ClassesCreature toClassesCreature(ClassesCreatureDto classesCreatureDto);
	@Mapping(source = "side.id", target = "sideId")
	ClassesCreatureDto toClassesCreatureDto(ClassesCreature classesCreature);
	List<ClassesCreatureDto> toListClassesCreatureDto(List<ClassesCreature> classesCreatures);

	Side toSide(SideDto sideDto);
	SideDto toSideDto(Side side);

	@Mapping(source = "classesCreature.id", target = "classesCreatureId")
	FamilyTypeDto toFamilyTypeDto(FamilyType familyType);
	@Mapping(source = "classesCreatureId", target = "classesCreature.id")
	FamilyType toFamilyType(FamilyTypeDto familyTypeDto);

}