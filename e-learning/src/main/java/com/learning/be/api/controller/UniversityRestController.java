package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.UniversityDto;

@RestController
@RequestMapping("/university")
public class UniversityRestController extends CrudAbstractRestController<UniversityDto, Long> {
	
}
