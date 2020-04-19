package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.service.FacultyService;
import com.learning.be.persistence.entities.Faculty;

@Service
public class FacultyServiceImpl extends AbstractJpaService<FacultyDto, Faculty, Long> implements FacultyService {

	public FacultyServiceImpl() {
		super(Faculty.class, FacultyDto.class);
	}

}
