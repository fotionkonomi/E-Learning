package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.RoleDto;
import com.learning.be.business.service.RoleService;
import com.learning.be.persistence.entities.Role;

@Service
public class RoleServiceImpl extends AbstractJpaService<RoleDto, Role, Long> implements RoleService {

	public RoleServiceImpl() {
		super(Role.class, RoleDto.class);
	}

	
}
