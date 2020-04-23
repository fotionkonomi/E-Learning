package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.business.dto.UniversityDto;

@RestController
@RequestMapping("/university")
public class UniversityRestController extends CrudAbstractRestController<UniversityDto, UniversityModel, Long> {
	
//	@Override
//	@GetMapping
//	public ResponseEntity<CollectionModel<UniversityModel>> findAll() {
//		return super.findAll();
//	}
//	
//	@Override
//	@GetMapping("/{id}")
//	public ResponseEntity<UniversityModel> findOne(@PathVariable("id") Long id) {
//		return super.findOne(id);
//	}

}
