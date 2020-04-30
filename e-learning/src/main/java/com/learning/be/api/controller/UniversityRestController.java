package com.learning.be.api.controller;

import java.net.URISyntaxException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.business.dto.UniversityDto;

@RestController
@RequestMapping("/university")
public class UniversityRestController extends CrudAbstractRestController<UniversityDto, UniversityModel, Long> {
	
	@Override
	@GetMapping
	public ResponseEntity<CollectionModel<UniversityModel>> findAll() {
		return super.findAll();
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UniversityModel> findOne(@PathVariable("id") Long id) {
		return super.findOne(id);
	}
	
	@Override
	@PostMapping
	public ResponseEntity<Void> createObject(@RequestBody UniversityDto dto) throws URISyntaxException {
		return super.createObject(dto);
	}

}
