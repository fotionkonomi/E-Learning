package com.learning.be.api.hateoas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.AnswerRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.AnswerModel;
import com.learning.be.business.dto.AnswerDto;

@Component
public class AnswerModelAssembler extends RepresentationModelAssemblerSupport<AnswerDto, AnswerModel> {

	@Autowired
	private AssemblerUtil assembler;

	public AnswerModelAssembler() {
		super(AnswerRestController.class, AnswerModel.class);
	}

	@Override
	public AnswerModel toModel(AnswerDto entity) {
		AnswerModel answerModel = instantiateModel(entity);

		answerModel.add(linkTo(methodOn(AnswerRestController.class).findOne(entity.getId())).withSelfRel());

		answerModel.setId(entity.getId());
		answerModel.setTimestamp(entity.getTimestamp());
		answerModel.setAnswer(entity.getAnswer());
		answerModel.setCorrect(entity.getCorrect());
		answerModel.setQuestion(assembler.toQuestionModel(entity.getQuestion()));
		answerModel.setUsersThatChoseThisAnswer(
				new HashSet<>(assembler.toCollectionUserModel(entity.getUsersThatChoseThisAnswer())));
		return answerModel;
	}

	@Override
	public CollectionModel<AnswerModel> toCollectionModel(Iterable<? extends AnswerDto> entities) {
		CollectionModel<AnswerModel> answerModels = super.toCollectionModel(entities);

		answerModels.add(linkTo(methodOn(AnswerRestController.class).findAll()).withSelfRel());

		return answerModels;
	}

}
