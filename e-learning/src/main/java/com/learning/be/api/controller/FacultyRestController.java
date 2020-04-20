package com.learning.be.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.assemblers.FacultyModelAssembler;
import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private FacultyModelAssembler facultyModelAssembler;

	@GetMapping
	public ResponseEntity<CollectionModel<FacultyModel>> findAll() {
		List<FacultyDto> faculties = facultyService.findAll();
		return new ResponseEntity<>(facultyModelAssembler.toCollectionModel(faculties), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FacultyModel> findOne(@PathVariable("id") Long id) {
		return facultyService.findById(id)
				.map(facultyModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
