package com.learning.be.business.service;

import java.util.List;

import com.learning.be.business.dto.CourseDto;

public interface CourseService extends BaseService<CourseDto, Long> {

	List<CourseDto> findByProfessor(Long professorId);
	
}
