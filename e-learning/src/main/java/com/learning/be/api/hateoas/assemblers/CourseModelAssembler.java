package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.controller.CourseRestController;
import com.learning.be.api.hateoas.model.CourseModel;
import com.learning.be.business.dto.CourseDto;

public class CourseModelAssembler extends RepresentationModelAssemblerSupport<CourseDto, CourseModel> {

	public CourseModelAssembler() {
		super(CourseRestController.class, CourseModel.class);
	}

	@Override
	public CourseModel toModel(CourseDto dto) {
		return createModelWithId(dto.getId(), dto);
	}

}
