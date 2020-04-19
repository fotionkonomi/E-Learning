package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.UserDto;
import com.learning.be.business.service.UserService;
import com.learning.be.persistence.entities.User;

@Service
public class UserServiceImpl extends AbstractJpaService<UserDto, User, Long> implements UserService {

	public UserServiceImpl() {
		super(User.class, UserDto.class);
	}

}
