package com.learning.be.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.UserDto;
import com.learning.be.business.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController extends CrudAbstractRestController<UserDto, Long> {

	@Autowired
	private UserService userService;
	
	@PostMapping("/username")
	public UserDto findUserByUsername(@RequestBody String username) {
		return userService.findByUsername(username);
	}

}
