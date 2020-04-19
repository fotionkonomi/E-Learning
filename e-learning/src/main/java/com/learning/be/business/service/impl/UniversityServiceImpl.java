package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.service.UniversityService;
import com.learning.be.persistence.entities.University;

@Service
public class UniversityServiceImpl extends AbstractJpaService<UniversityDto, University, Long>
		implements UniversityService {

	public UniversityServiceImpl() {
		super(University.class, UniversityDto.class);
	}

}
