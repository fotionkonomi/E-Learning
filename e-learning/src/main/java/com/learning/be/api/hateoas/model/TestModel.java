package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.learning.be.api.hateoas.assemblers.CourseModelAssembler;
import com.learning.be.api.hateoas.assemblers.QuestionModelAssembler;
import com.learning.be.business.dto.TestDto;

import lombok.Getter;

public class TestModel extends RepresentationModel<TestModel> {

	@Getter
	private final Long id;
	
	@Getter
	private final Date timestamp;
	
	@Getter
	private final String name;
	
	@Getter
	private final CourseModel course;
	
	@Getter
	private final Set<QuestionModel> questions;
	
	public TestModel(TestDto test) {
		this.id = test.getId();
		this.timestamp = test.getTimestamp();
		this.name = test.getName();
		this.course = new CourseModelAssembler().toModel(test.getCourse());
		questions = new HashSet<>();
		QuestionModelAssembler questionModelAssembler = new QuestionModelAssembler();
		test.getQuestions().forEach(question -> questions.add(questionModelAssembler.toModel(question)));
	}
}
