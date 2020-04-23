package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.CourseModel;
import com.learning.be.business.dto.CourseDto;

@RestController
@RequestMapping("/course")
public class CourseRestController extends CrudAbstractRestController<CourseDto, CourseModel, Long>{

	@Override
	@GetMapping
	public ResponseEntity<CollectionModel<CourseModel>> findAll() {
		return super.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CourseModel> findOne(@PathVariable("id") Long id) {
		return super.findOne(id);
	}

}
