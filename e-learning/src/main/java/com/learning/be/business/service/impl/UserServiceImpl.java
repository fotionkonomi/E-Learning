package com.learning.be.business.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.be.business.dto.UserDto;
import com.learning.be.business.service.UserService;
import com.learning.be.persistence.entities.User;
import com.learning.be.persistence.repository.UserRepository;

@Service
public class UserServiceImpl extends AbstractJpaService<UserDto, User, Long> implements UserService {

	@Autowired
	private UserRepository userRepo;

	public UserServiceImpl() {
		super(User.class, UserDto.class);
	}

	@Override
	public UserDto findByUsername(String username) {
		Optional<User> optionalUser = userRepo.findByUsername(username);
		if (optionalUser.isPresent()) {
			return mapFromEntity(optionalUser.get());
		} else {
			return null;
		}
	}

}
