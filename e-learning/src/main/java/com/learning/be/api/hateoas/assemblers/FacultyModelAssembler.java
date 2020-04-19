package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.controller.FacultyRestController;
import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.business.dto.FacultyDto;

public class FacultyModelAssembler extends RepresentationModelAssemblerSupport<FacultyDto, FacultyModel> {

	public FacultyModelAssembler() {
		super(FacultyRestController.class, FacultyModel.class);
	}

	@Override
	public FacultyModel toModel(FacultyDto dto) {
		return createModelWithId(dto.getId(), dto);
	}

}
