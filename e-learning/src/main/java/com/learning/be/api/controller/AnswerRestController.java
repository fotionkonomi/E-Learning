package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.AnswerModel;
import com.learning.be.business.dto.AnswerDto;

@RestController
@RequestMapping("/answer")
public class AnswerRestController extends CrudAbstractRestController<AnswerDto, AnswerModel, Long> {

	@Override
	@GetMapping
	public ResponseEntity<CollectionModel<AnswerModel>> findAll() {
		return super.findAll();
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<AnswerModel> findOne(@PathVariable("id") Long id) {
		return super.findOne(id);
	}
}
