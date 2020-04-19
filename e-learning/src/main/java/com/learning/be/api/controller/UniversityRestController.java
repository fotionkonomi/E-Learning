package com.learning.be.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.service.UniversityService;
import com.learning.be.common.constants.MessageConstants;
import com.learning.be.common.exception.ConstraintException;

@RestController
@RequestMapping("/university")
@CrossOrigin(origins = "*")
public class UniversityRestController {

	@Autowired
	private UniversityService universityService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> add(@RequestBody UniversityDto universityDto) {
		try {
			universityService.save(universityDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.MSG_SAVED_SUCCESSFULLY);
		} catch (ConstraintException e) {
			return ResponseEntity.badRequest().body(MessageConstants.MSG_CONSTRAINT_EXCEPTION);
		}
	}

	@GetMapping
	public ResponseEntity<CollectionModel<UniversityModel>> findAll() {
//		List<UniversityDto> universityDtos = universityService.findAll();
//
//		CollectionModel<UniversityModel> universityModels = new UniversityModelAssembler()
//				.toCollectionModel(universityDtos);
//		
//		universityModels.add(
//				 WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UniversityRestController.class).findAllUniversities())
//				 .withRel("universities"));
//
//		return ResponseEntity.status(HttpStatus.OK).body(universityModels);

		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UniversityModel> findOne(@PathVariable("id") Long id) {
		return null;
	}

}
