package com.learning.be.api.hateoas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.learning.be.api.hateoas.assemblers.UniversityModelAssembler;
import com.learning.be.api.hateoas.assemblers.UserModelAssembler;
import com.learning.be.business.dto.FacultyDto;

import lombok.Getter;

public class FacultyModel extends RepresentationModel<FacultyModel> {

	@Getter
	private final Long id;
	
	@Getter
	private final Date timestamp;
	
	@Getter
	private final String name;
	
	@Getter
	private UniversityModel university;
	
	@Getter
	private List<UserModel> studentsAndProfessors;
	
	public FacultyModel(FacultyDto faculty) {
		this.id = faculty.getId();
		this.timestamp = faculty.getTimestamp();
		this.name = faculty.getName();
		this.university = new UniversityModelAssembler().toModel(faculty.getUniversity());
		UserModelAssembler userModelAssembler = new UserModelAssembler();
		studentsAndProfessors = new ArrayList<>();
		faculty.getStudentsAndProfessors().forEach(user -> studentsAndProfessors.add(userModelAssembler.toModel(user)));
	}
}
