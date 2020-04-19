package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.QuestionDto;
import com.learning.be.business.service.QuestionService;
import com.learning.be.persistence.entities.Question;

@Service
public class QuestionServiceImpl extends AbstractJpaService<QuestionDto, Question, Long> implements QuestionService {

	public QuestionServiceImpl() {
		super(Question.class, QuestionDto.class);
	}

}
