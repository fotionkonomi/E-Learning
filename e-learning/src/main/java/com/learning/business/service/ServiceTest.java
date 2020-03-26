package com.learning.business.service;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.business.dto.FacultyDto;
import com.learning.persistence.entities.Faculty;
import com.learning.persistence.entities.University;

@Component
public class ServiceTest {

	@Autowired
	private ModelMapper modelMapper;
	
	public FacultyDto faculty() {
		University university = new University();
		university.setId(1L);
		university.setTimestamp(new Date());
		university.setName("UPT");
		university.setAddress("Nene Tereza");
		
		Faculty faculty = new Faculty();
		faculty.setId(2L);
		faculty.setName("FTI");
		faculty.setUniversity(university);
		faculty.setTimestamp(new Date());
		
		return modelMapper.map(faculty, FacultyDto.class);
		
	}
}
