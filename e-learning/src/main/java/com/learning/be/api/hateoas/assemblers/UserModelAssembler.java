package com.learning.be.api.hateoas.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.UserRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.UserDto;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public UserModelAssembler() {
		super(UserRestController.class, UserModel.class);
	}

	@Override
	public UserModel toModel(UserDto entity) {
		UserModel userModel = instantiateModel(entity);

		userModel.add(linkTo(methodOn(UserRestController.class, entity.getId()).findOne(entity.getId())).withSelfRel());

		userModel.setId(entity.getId());
		userModel.setTimestamp(entity.getTimestamp());
		userModel.setFirstName(entity.getFirstName());
		userModel.setLastName(entity.getLastName());
		userModel.setUsername(entity.getUsername());
		userModel.setGender(entity.getGender());
		userModel.setEmail(entity.getEmail());
		userModel.setDateOfBirth(entity.getDateOfBirth());
		userModel.setDateRegistered(entity.getDateRegistered());
		userModel.setFaculty(assemblerUtil.toFacultyModel(entity.getFaculty()));
		userModel.setRole(entity.getRole());
		userModel.setMyStudentCourses(
				new HashSet<>(assemblerUtil.toCollectionCourseModels(entity.getMyStudentCourses())));
		userModel.setMyProfessorCourses(
				new ArrayList<>(assemblerUtil.toCollectionCourseModels(entity.getMyProfessorCourses())));
		userModel.setMyAnswers(new HashSet<>(assemblerUtil.toCollectionAnswerModel(entity.getMyAnswers())));

		return userModel;

	}

	@Override
	public CollectionModel<UserModel> toCollectionModel(Iterable<? extends UserDto> entities) {
		CollectionModel<UserModel> userModels = super.toCollectionModel(entities);

		userModels.add(linkTo(methodOn(UserRestController.class).findAll()).withSelfRel());

		return userModels;
	}
}
