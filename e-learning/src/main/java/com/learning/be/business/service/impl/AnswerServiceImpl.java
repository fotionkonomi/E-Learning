package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.AnswerDto;
import com.learning.be.business.service.AnswerService;
import com.learning.be.persistence.entities.Answer;

@Service
public class AnswerServiceImpl extends AbstractJpaService<AnswerDto, Answer, Long> implements AnswerService {

	public AnswerServiceImpl() {
		super(Answer.class, AnswerDto.class);
	}

}
