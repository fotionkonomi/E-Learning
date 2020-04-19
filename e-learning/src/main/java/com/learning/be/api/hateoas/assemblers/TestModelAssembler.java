package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.controller.TestRestController;
import com.learning.be.api.hateoas.model.TestModel;
import com.learning.be.business.dto.TestDto;

public class TestModelAssembler extends RepresentationModelAssemblerSupport<TestDto, TestModel> {

	public TestModelAssembler() {
		super(TestRestController.class, TestModel.class);
	}

	@Override
	public TestModel toModel(TestDto dto) {
		return createModelWithId(dto.getId(), dto);
	}
}
