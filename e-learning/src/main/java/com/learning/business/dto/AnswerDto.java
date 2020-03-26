package com.learning.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnswerDto extends BaseClassDto {

	private String answer;
	
	private Boolean correct;
	
	private QuestionDto question;
}
