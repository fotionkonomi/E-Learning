package com.learning.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.business.dto.FacultyDto;
import com.learning.business.service.ServiceTest;
import com.learning.persistence.entities.Answer;

@RestController
@RequestMapping("/controller")
public class Controller {

	@Autowired
	private ServiceTest serviceTest;
	
	@GetMapping("/faculty")
	public int faculty() {
		return serviceTest.faculty();
	}
}
