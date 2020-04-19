package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.business.dto.UniversityDto;

public class UniversityModelAssembler extends RepresentationModelAssemblerSupport<UniversityDto, UniversityModel> {

	public UniversityModelAssembler() {
		super(UniversityDto.class, UniversityModel.class);
	}

	@Override
	public UniversityModel toModel(UniversityDto dto) {
		return createModelWithId(dto.getId(), dto);
	}
}
