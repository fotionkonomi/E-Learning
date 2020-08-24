package com.learning.be.business.service;

import com.learning.be.business.dto.UserDto;

public interface UserService extends BaseService<UserDto, Long> {

	UserDto findByUsername(final String username);
}
