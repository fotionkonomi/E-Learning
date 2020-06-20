package com.learning.be.business.service;

import java.util.List;

import com.learning.be.business.dto.FacultyDto;

public interface FacultyService extends BaseService<FacultyDto, Long> {

	List<FacultyDto> findFacultiesOfAUniversity(Long universityId);
}
