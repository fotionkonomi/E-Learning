package com.learning.be.api.hateoas.assemblers;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.QuestionRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.business.dto.QuestionDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class QuestionModelAssembler extends RepresentationModelAssemblerSupport<QuestionDto, QuestionModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public QuestionModelAssembler() {
		super(QuestionRestController.class, QuestionModel.class);
	}

	@Override
	public QuestionModel toModel(QuestionDto entity) {
		QuestionModel questionModel = instantiateModel(entity);

		questionModel.add(linkTo(methodOn(QuestionRestController.class).findOne(entity.getId())).withSelfRel());

		questionModel.setId(entity.getId());
		questionModel.setTimestamp(entity.getTimestamp());
		questionModel.setQuestion(entity.getQuestion());
		questionModel.setDifficulty(entity.getDifficulty());
		questionModel.setNumberOfPoints(entity.getNumberOfPoints());
		questionModel.setAnswers(new ArrayList<>(assemblerUtil.toCollectionAnswerModel(entity.getAnswers())));
		questionModel.setTests(new HashSet<>(assemblerUtil.toCollectionTestModel(entity.getTests())));

		return questionModel;
	}

	@Override
	public CollectionModel<QuestionModel> toCollectionModel(Iterable<? extends QuestionDto> entities) {
		CollectionModel<QuestionModel> questionModels = super.toCollectionModel(entities);

		questionModels.add(linkTo(methodOn(QuestionRestController.class).findAll()).withSelfRel());

		return questionModels;
	}

}
