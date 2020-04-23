package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.TestRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.TestModel;
import com.learning.be.business.dto.TestDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TestModelAssembler extends RepresentationModelAssemblerSupport<TestDto, TestModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public TestModelAssembler() {
		super(TestRestController.class, TestModel.class);
	}

	@Override
	public TestModel toModel(TestDto entity) {
		TestModel testModel = instantiateModel(entity);

		testModel.add(linkTo(methodOn(TestRestController.class, entity.getId()).findOne(entity.getId())).withSelfRel());

		testModel.setId(entity.getId());
		testModel.setTimestamp(entity.getTimestamp());
		testModel.setName(entity.getName());
		testModel.setCourse(assemblerUtil.toCourseModel(entity.getCourse()));
		testModel.setQuestions(new HashSet<>(assemblerUtil.toCollectionQuestionModels(entity.getQuestions())));

		return testModel;
	}

	@Override
	public CollectionModel<TestModel> toCollectionModel(Iterable<? extends TestDto> entities) {
		CollectionModel<TestModel> testModels = super.toCollectionModel(entities);

		testModels.add(linkTo(methodOn(TestRestController.class).findAll()).withSelfRel());

		return testModels;
	}
}
