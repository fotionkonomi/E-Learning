package com.learning.be.api.hateoas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.learning.be.api.hateoas.assemblers.TestModelAssembler;
import com.learning.be.api.hateoas.assemblers.UserModelAssembler;
import com.learning.be.business.dto.CourseDto;

import lombok.Getter;

public class CourseModel extends RepresentationModel<CourseModel> {

	@Getter
	private final Long id;

	@Getter
	private final Date timestamp;

	@Getter
	private final UserModel professor;

	@Getter
	private final List<TestModel> tests;

	@Getter
	private final Set<UserModel> students;

	public CourseModel(CourseDto course) {
		this.id = course.getId();
		this.timestamp = course.getTimestamp();
		this.professor = new UserModelAssembler().toModel(course.getProfessor());
		TestModelAssembler testModelAssembler = new TestModelAssembler();
		tests = new ArrayList<>();
		course.getTests().forEach(test -> tests.add(testModelAssembler.toModel(test)));
		UserModelAssembler userModelAssembler = new UserModelAssembler();
		students = new HashSet<>();
		course.getStudents().forEach(student -> students.add(userModelAssembler.toModel(student)));
	}
}
