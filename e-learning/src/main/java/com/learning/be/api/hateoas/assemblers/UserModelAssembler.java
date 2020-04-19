package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.learning.be.api.controller.UserRestController;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.UserDto;

public class UserModelAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

	public UserModelAssembler() {
		super(UserRestController.class, UserModel.class);
	}

	@Override
	public UserModel toModel(UserDto dto) {
		return createModelWithId(dto.getId(), dto);
	}
}
