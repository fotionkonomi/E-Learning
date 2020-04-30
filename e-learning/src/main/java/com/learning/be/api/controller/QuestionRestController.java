package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.QuestionDto;

@RestController
@RequestMapping("/question")
public class QuestionRestController extends CrudAbstractRestController<QuestionDto, Long> {

}
