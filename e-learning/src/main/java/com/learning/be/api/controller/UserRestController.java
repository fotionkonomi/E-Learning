package com.learning.be.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserRestController extends CrudAbstractRestController<UserDto, UserModel, Long> {

	@Override
	@GetMapping
	public ResponseEntity<CollectionModel<UserModel>> findAll() {
		return super.findAll();
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> findOne(@PathVariable("id") Long id) {
		return super.findOne(id);
	}
}
