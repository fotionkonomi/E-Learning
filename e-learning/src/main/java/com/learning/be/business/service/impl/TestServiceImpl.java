package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.TestDto;
import com.learning.be.business.service.TestService;
import com.learning.be.persistence.entities.Test;

@Service
public class TestServiceImpl extends AbstractJpaService<TestDto, Test, Long> implements TestService {

	public TestServiceImpl() {
		super(Test.class, TestDto.class);
	}

}
