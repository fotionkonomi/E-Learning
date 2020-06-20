package com.learning.be.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController extends CrudAbstractRestController<FacultyDto, Long> {
	
	@Autowired
	private FacultyService service;
	
	@GetMapping("/university/{universityId}")
	public List<FacultyDto> findFacultiesOfAUniversity(@PathVariable("universityId") Long universityId) {
		return service.findFacultiesOfAUniversity(universityId);
	}
}
