package com.learning.be.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.CourseDto;
import com.learning.be.business.service.CourseService;
import com.learning.be.persistence.entities.Course;
import com.learning.be.persistence.repository.CourseRepository;

@Service
public class CourseServiceImpl extends AbstractJpaService<CourseDto, Course, Long> implements CourseService {
	
	public CourseServiceImpl() {
		super(Course.class, CourseDto.class);
	}

	@Override
	public List<CourseDto> findByProfessor(Long professorId) {
		return mapEntityListToDTO(((CourseRepository)repo).findByProfessor_Id(professorId));
	}

}
