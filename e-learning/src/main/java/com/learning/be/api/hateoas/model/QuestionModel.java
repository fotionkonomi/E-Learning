package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.learning.be.business.dto.enums.QuestionDifficulty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "question")
@Relation(collectionRelation = "questions")
@JsonInclude(value = Include.NON_NULL)
public class QuestionModel extends RepresentationModel<QuestionModel> {

	private Long id;
	
	private Date timestamp;
	
	private String question;
	
	private QuestionDifficulty difficulty;
	
	private Long numberOfPoints;
	
	private List<AnswerModel> answers;
	
	private Set<TestModel> tests;

}
