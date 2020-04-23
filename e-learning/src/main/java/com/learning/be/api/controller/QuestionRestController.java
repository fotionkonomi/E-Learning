package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.business.dto.QuestionDto;

@RestController
@RequestMapping("/question")
public class QuestionRestController extends CrudAbstractRestController<QuestionDto, QuestionModel, Long> {

	@Override
	@GetMapping
	public ResponseEntity<CollectionModel<QuestionModel>> findAll() {
		return super.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<QuestionModel> findOne(@PathVariable("id") Long id) {
		return super.findOne(id);
	}
}
