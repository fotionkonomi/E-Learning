package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.controller.QuestionRestController;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.business.dto.QuestionDto;

public class QuestionModelAssembler extends RepresentationModelAssemblerSupport<QuestionDto, QuestionModel> {

	public QuestionModelAssembler() {
		super(QuestionRestController.class, QuestionModel.class);
	}

	@Override
	public QuestionModel toModel(QuestionDto dto) {
		return createModelWithId(dto.getId(), dto);
	}

}
