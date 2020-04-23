package com.learning.be.api.hateoas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.CourseRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.CourseModel;
import com.learning.be.business.dto.CourseDto;

@Component
public class CourseModelAssembler extends RepresentationModelAssemblerSupport<CourseDto, CourseModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public CourseModelAssembler() {
		super(CourseRestController.class, CourseModel.class);
	}

	@Override
	public CourseModel toModel(CourseDto entity) {
		CourseModel courseModel = instantiateModel(entity);

		courseModel.add(linkTo(methodOn(CourseRestController.class, entity.getId()).findOne(entity.getId())).withSelfRel());

		courseModel.setId(entity.getId());
		courseModel.setTimestamp(entity.getTimestamp());
		courseModel.setProfessor(assemblerUtil.toUserModel(entity.getProfessor()));
		courseModel.setTests(new ArrayList<>(assemblerUtil.toCollectionTestModel(entity.getTests())));
		courseModel.setStudents(new HashSet<>(assemblerUtil.toCollectionUserModel(entity.getStudents())));

		return courseModel;

	}

	@Override
	public CollectionModel<CourseModel> toCollectionModel(Iterable<? extends CourseDto> entities) {
		CollectionModel<CourseModel> courseModels = super.toCollectionModel(entities);

		courseModels.add(linkTo(methodOn(CourseRestController.class).findAll()).withSelfRel());

		return courseModels;
	}

}
