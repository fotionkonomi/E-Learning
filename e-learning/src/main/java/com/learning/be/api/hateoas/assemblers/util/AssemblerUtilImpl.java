package com.learning.be.api.hateoas.assemblers.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.be.api.controller.QuestionRestController;
import com.learning.be.api.controller.UserRestController;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.QuestionDto;
import com.learning.be.business.dto.UserDto;

@Service
public class AssemblerUtilImpl implements AssemblerUtil {

	@Override
	public QuestionModel toQuestionModel(QuestionDto questionDto) {
		return QuestionModel.builder()
			.id(questionDto.getId())
			.timestamp(questionDto.getTimestamp())
			.question(questionDto.getQuestion())
			.difficulty(questionDto.getDifficulty())
			.numberOfPoints(questionDto.getNumberOfPoints())
				.build()
				.add(linkTo(methodOn(QuestionRestController.class)
						.findOne(questionDto.getId()))
						.withSelfRel());
					
	}
		
	@Override
	public Collection<UserModel> toCollectionUserModel(Collection<UserDto> userDtos) {
		if (userDtos.isEmpty())
            return Collections.emptyList();
		
		return userDtos.stream()
			.map(user -> UserModel.builder()
					.id(user.getId())
					.timestamp(user.getTimestamp())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.username(user.getUsername())
					.gender(user.getGender())
					.email(user.getEmail())
					.dateOfBirth(user.getDateOfBirth())
					.dateRegistered(user.getDateRegistered())
					.build()
					.add(linkTo(methodOn(UserRestController.class)
							.findOne(user.getId()))
							.withSelfRel())).collect(Collectors.toList());
	}

	
}
