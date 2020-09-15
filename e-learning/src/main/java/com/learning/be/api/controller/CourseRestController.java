package com.learning.be.api.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.CourseDto;
import com.learning.be.business.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController extends CrudAbstractRestController<CourseDto, Long> {

	@PostMapping("/user")
	public Collection<CourseDto> coursesOfProfessor(@RequestBody Long userId) {
		return ((CourseService) service).findByProfessor(userId);
	}
}
