package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.CourseDto;

@RestController
@RequestMapping("/course")
public class CourseRestController extends CrudAbstractRestController<CourseDto, Long>{

}
