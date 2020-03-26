package com.learning.business.dto;

import com.learning.business.dto.enums.QuestionDifficulty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuestionDto extends BaseClassDto {

	private String question;
	
	private Boolean correct;
	
	private QuestionDifficulty difficulty;
	
	private Long numberOfPoints;
}
