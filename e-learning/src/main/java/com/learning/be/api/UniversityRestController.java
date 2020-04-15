package com.learning.be.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.service.UniversityService;
import com.learning.be.common.constants.MessageConstants;
import com.learning.be.common.exception.ConstraintException;

@RestController
@RequestMapping("/api/university")
public class UniversityRestController {

	@Autowired
	private UniversityService universityService;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> addUniversity(@RequestBody UniversityDto universityDto) {
		try {
			universityService.save(universityDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.MSG_SAVED_SUCCESSFULLY);
		} catch(ConstraintException e) {
			return ResponseEntity.badRequest().body(MessageConstants.MSG_CONSTRAINT_EXCEPTION);
		}
	}
}
