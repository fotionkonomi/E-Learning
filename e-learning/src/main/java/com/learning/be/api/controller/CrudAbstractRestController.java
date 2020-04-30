package com.learning.be.api.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.be.business.dto.BaseClassDto;
import com.learning.be.business.service.BaseService;
import com.learning.be.common.exception.ConstraintException;
import com.learning.be.common.util.Utils;

public abstract class CrudAbstractRestController<DTO extends BaseClassDto, MODEL extends RepresentationModel<MODEL>, ID> {
	
	@Autowired
	private RepresentationModelAssemblerSupport<DTO, MODEL> representationModelAssembler;
	
	@Autowired
	private BaseService<DTO, ID> service;
	
	public ResponseEntity<CollectionModel<MODEL>> findAll() {
		List<DTO> dtos = service.findAll();
		return new ResponseEntity<>(representationModelAssembler.toCollectionModel(dtos), HttpStatus.OK);

	}

	public ResponseEntity<MODEL> findOne(@PathVariable("id") ID id) {
		return service.findById(id)
				.map(representationModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Void> createObject(@RequestBody DTO dto) throws URISyntaxException {
		try {
			dto = service.save(dto);
			return ResponseEntity.created(Utils.getUriAfterPost(dto)).build();
		} catch (ConstraintException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
