package com.learning.be.api.hateoas.assemblers.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.be.api.controller.AnswerRestController;
import com.learning.be.api.controller.CourseRestController;
import com.learning.be.api.controller.FacultyRestController;
import com.learning.be.api.controller.QuestionRestController;
import com.learning.be.api.controller.TestRestController;
import com.learning.be.api.controller.UniversityRestController;
import com.learning.be.api.controller.UserRestController;
import com.learning.be.api.hateoas.model.AnswerModel;
import com.learning.be.api.hateoas.model.CourseModel;
import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.api.hateoas.model.TestModel;
import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.AnswerDto;
import com.learning.be.business.dto.CourseDto;
import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.dto.QuestionDto;
import com.learning.be.business.dto.TestDto;
import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.dto.UserDto;

@Service
public class AssemblerUtilImpl implements AssemblerUtil {

	@Override
	public QuestionModel toQuestionModel(QuestionDto questionDto) {
		return QuestionModel.builder()
			.id(questionDto.getId())
			.timestamp(questionDto.getTimestamp())
			.question(questionDto.getQuestion())
			.difficulty(questionDto.getDifficulty())
			.numberOfPoints(questionDto.getNumberOfPoints())
				.build()
				.add(linkTo(methodOn(QuestionRestController.class)
						.findOne(questionDto.getId()))
						.withSelfRel());
					
	}
		
	@Override
	public Collection<UserModel> toCollectionUserModel(Collection<UserDto> userDtos) {
		if (userDtos.isEmpty())
            return Collections.emptyList();
		
		return userDtos.stream()
			.map(this::toUserModel)
			.collect(Collectors.toList());
	}
	
	@Override
	public Collection<FacultyModel> toCollectionFacultyModel(Collection<FacultyDto> faculties) {
		if (faculties.isEmpty())
            return Collections.emptyList();
		
		return faculties.stream()
				.map(this::toFacultyModel)
				.collect(Collectors.toList());
	}
	
	@Override
	public UniversityModel toUniversityModel(UniversityDto universityDto) {
		return UniversityModel.builder()
				.id(universityDto.getId())
				.timestamp(universityDto.getTimestamp())
				.name(universityDto.getName())
				.address(universityDto.getAddress())
				.build()
				.add(linkTo(methodOn(UniversityRestController.class).
						findOne(universityDto.getId())).
						withSelfRel());
	}

	@Override
	public UserModel toUserModel(UserDto user) {
		return UserModel.builder()
				.id(user.getId())
				.timestamp(user.getTimestamp())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.username(user.getUsername())
				.gender(user.getGender())
				.email(user.getEmail())
				.dateOfBirth(user.getDateOfBirth())
				.dateRegistered(user.getDateRegistered())
				.build()
				.add(linkTo(methodOn(UserRestController.class)
						.findOne(user.getId()))
						.withSelfRel());
	}

	@Override
	public Collection<TestModel> toCollectionTestModel(Collection<TestDto> tests) {
		if(tests.isEmpty()) {
			return Collections.emptyList();
		}
		
		return tests.stream()
				.map(test -> TestModel.builder()
					.id(test.getId())
					.timestamp(test.getTimestamp())
					.name(test.getName())
					.build()
					.add(linkTo(methodOn(TestRestController.class)
							.findOne(test.getId()))
							.withSelfRel()))
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<AnswerModel> toCollectionAnswerModel(Collection<AnswerDto> answers) {
		if(answers.isEmpty()) {
			return Collections.emptyList();
		}
		
		return answers.stream()
				.map(answer -> AnswerModel.builder()
						.id(answer.getId())
						.timestamp(answer.getTimestamp())
						.answer(answer.getAnswer())
						.correct(answer.getCorrect())
						.build()
						.add(linkTo(methodOn(AnswerRestController.class)
								.findOne(answer.getId())).withSelfRel())
						).collect(Collectors.toList());
	}
	
	@Override
	public CourseModel toCourseModel(CourseDto courseDto) {
		return CourseModel.builder()
				.id(courseDto.getId())
				.timestamp(courseDto.getTimestamp())
				.name(courseDto.getName())
				.build()
				.add(linkTo(methodOn(CourseRestController.class)
						.findOne(courseDto.getId())).withSelfRel());
	}
	
	@Override
	public Collection<QuestionModel> toCollectionQuestionModels(Collection<QuestionDto> questionDtos) {
		if(questionDtos.isEmpty()) {
			return Collections.emptyList();
		}
		
		return questionDtos.stream()
				.map(this::toQuestionModel)
				.collect(Collectors.toList());
	}
	
	@Override
	public FacultyModel toFacultyModel(FacultyDto faculty) {
		return FacultyModel.builder()
				.id(faculty.getId())
				.timestamp(faculty.getTimestamp())
				.name(faculty.getName())
				.build()
				.add(linkTo(methodOn(FacultyRestController.class)
						.findOne(faculty.getId()))
						.withSelfRel());
	}
	
	@Override
	public Collection<CourseModel> toCollectionCourseModels(Collection<CourseDto> courseDtos) {
		if(courseDtos.isEmpty()) {
			return Collections.emptyList();
		}
		
		return courseDtos.stream()
				.map(this::toCourseModel)
				.collect(Collectors.toList());
	}
}
