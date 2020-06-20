package com.learning.be.api.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.be.api.Utils;
import com.learning.be.business.dto.BaseClassDto;
import com.learning.be.business.service.BaseService;
import com.learning.be.common.exception.ConstraintException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CrudAbstractRestController<DTO extends BaseClassDto, ID> {

	@Autowired
	private BaseService<DTO, ID> service;
	
	@GetMapping
	public ResponseEntity<Collection<DTO>> findAll() {
		List<DTO> dtos = service.findAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<DTO> findOne(@PathVariable("id") ID id) {
		return service.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createObject(@RequestBody DTO dto) throws URISyntaxException {
		try {
			dto = service.save(dto);
			return ResponseEntity.created(Utils.getUriAfterPost(dto)).build();
		} catch (ConstraintException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
