package com.learning.be.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.service.FacultyService;
import com.learning.be.persistence.entities.Faculty;
import com.learning.be.persistence.repository.FacultyRepository;

@Service
public class FacultyServiceImpl extends AbstractJpaService<FacultyDto, Faculty, Long> implements FacultyService {

	@Autowired
	private FacultyRepository repo;
	
	public FacultyServiceImpl() {
		super(Faculty.class, FacultyDto.class);
	}

	@Override
	public List<FacultyDto> findFacultiesOfAUniversity(Long universityId) {
		return mapEntityListToDTO(repo.findByUniversityId(universityId));
	}

}
