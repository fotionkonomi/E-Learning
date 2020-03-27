package com.learning.business.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.learning.persistence.entities.User;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnswerDto extends BaseClassDto {

	@Size(max = 65535)
	@NotEmpty
	private String answer;
	
	@NotNull
	private Boolean correct;
	
	private QuestionDto question;
	
	private Set<UserDto> usersThatChoseThisAnswer = new HashSet<>();
	
}
