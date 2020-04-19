package com.learning.be.business.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	private Boolean correct;
	
	private QuestionDto question;
	
	private Set<UserDto> usersThatChoseThisAnswer = new HashSet<>();
	
}
