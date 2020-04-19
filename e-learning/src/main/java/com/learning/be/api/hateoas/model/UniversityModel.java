package com.learning.be.api.hateoas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.learning.be.api.hateoas.assemblers.FacultyModelAssembler;
import com.learning.be.business.dto.UniversityDto;

import lombok.Getter;

@JsonRootName(value = "university")
@Relation(collectionRelation = "universities")
@JsonInclude(value = Include.NON_NULL)
public class UniversityModel extends RepresentationModel<UniversityModel> {
	
	@Getter
	private final Long id;
	
	@Getter
	private final Date timestamp;
	
	@Getter
	private final String name;
	
	@Getter
	private final String address;
	
	@Getter
	private final List<FacultyModel> faculties;
	
	public UniversityModel(UniversityDto university) {
		this.id = university.getId();
		this.timestamp = university.getTimestamp();
		this.name = university.getName();
		this.address = university.getAddress();
		faculties = new ArrayList<>();
		FacultyModelAssembler facultyModelAssembler = new FacultyModelAssembler();
		university.getFaculties().forEach(faculty -> faculties.add(facultyModelAssembler.toModel(faculty)));
	}
}
