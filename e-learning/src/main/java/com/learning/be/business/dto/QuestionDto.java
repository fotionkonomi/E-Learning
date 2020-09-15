package com.learning.be.business.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.learning.be.business.dto.enums.QuestionDifficulty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = QuestionDto.class)
public class QuestionDto extends BaseClassDto {

	@Size(max = 65535)
	@NotEmpty
	private String question;
	
	private Boolean correct;
	
	private QuestionDifficulty difficulty;
	
	private Long numberOfPoints;
	
	private TestDto test;
	
	private List<AnswerDto> answers = new ArrayList<>();

	
}
