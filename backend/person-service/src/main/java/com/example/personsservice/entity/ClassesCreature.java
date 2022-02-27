package com.example.personsservice.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode.Exclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes_creature")
public class ClassesCreature {

	@Id
	@Exclude
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_creature")
	private String name;

	@Column(name = "description")
	private String description;

	@Exclude
	@ManyToOne
	@JoinColumn(name = "side_id")
	private Side side;

	@Exclude
	@OneToMany(mappedBy = "classesCreature")
	private List<FamilyType> familyTypes;
}