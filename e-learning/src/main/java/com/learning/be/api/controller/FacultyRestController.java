package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.FacultyModel;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController {

	@GetMapping
	public ResponseEntity<CollectionModel<FacultyModel>> findAll() {
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FacultyModel> findOne(@PathVariable("id") Long id) {
		return null;
	}
}
