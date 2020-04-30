package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.FacultyDto;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController extends CrudAbstractRestController<FacultyDto, Long> {

}
