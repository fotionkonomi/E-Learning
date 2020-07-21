package com.learning.be.business.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = AnswerDto.class)
public class AnswerDto extends BaseClassDto {

	@Size(max = 65535)
	@NotEmpty
	private String answer;
	
	private Boolean correct;
	
	private QuestionDto question;
	
	private Set<UserDto> usersThatChoseThisAnswer = new HashSet<>();
	
}
