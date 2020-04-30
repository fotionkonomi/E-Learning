package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.AnswerDto;

@RestController
@RequestMapping("/answer")
public class AnswerRestController extends CrudAbstractRestController<AnswerDto, Long> {

}
