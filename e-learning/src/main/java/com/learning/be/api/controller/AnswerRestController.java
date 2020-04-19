package com.learning.be.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.AnswerModel;
import com.learning.be.business.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerRestController {

	@Autowired
	private AnswerService answerService;
	
	@GetMapping
	public ResponseEntity<CollectionModel<AnswerModel>> findAll() {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnswerModel> findOne(@PathVariable("id") Long id) {
		return null;
	}
}
