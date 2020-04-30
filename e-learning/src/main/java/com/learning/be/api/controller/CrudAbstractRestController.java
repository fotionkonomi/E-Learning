package com.learning.be.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.be.business.service.BaseService;

public abstract class CrudAbstractRestController<DTO, ID> {

	@Autowired
	private BaseService<DTO, ID> service;
	
	
	public ResponseEntity<Collection<DTO>> findAll() {
		List<DTO> dtos = service.findAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);

	}

	public ResponseEntity<DTO> findOne(@PathVariable("id") ID id) {
		return service.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

}
