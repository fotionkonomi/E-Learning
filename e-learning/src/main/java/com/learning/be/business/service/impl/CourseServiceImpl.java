package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.CourseDto;
import com.learning.be.business.service.CourseService;
import com.learning.be.persistence.entities.Course;

@Service
public class CourseServiceImpl extends AbstractJpaService<CourseDto, Course, Long> implements CourseService {

	public CourseServiceImpl() {
		super(Course.class, CourseDto.class);
	}

}
