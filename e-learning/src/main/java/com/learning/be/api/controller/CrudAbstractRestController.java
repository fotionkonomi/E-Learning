package com.learning.be.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.be.business.service.BaseService;

public abstract class CrudAbstractRestController<DTO, MODEL extends RepresentationModel<MODEL>, ID> {
	
	@Autowired
	private RepresentationModelAssemblerSupport<DTO, MODEL> representationModelAssembler;
	
	@Autowired
	private BaseService<DTO, ID> service;
	
	@GetMapping
	public ResponseEntity<CollectionModel<MODEL>> findAll() {
		List<DTO> dtos = service.findAll();
		return new ResponseEntity<>(representationModelAssembler.toCollectionModel(dtos), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<MODEL> findOne(@PathVariable("id") ID id) {
		return service.findById(id)
				.map(representationModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

}
