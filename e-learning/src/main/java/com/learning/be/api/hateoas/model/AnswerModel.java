package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.learning.be.api.hateoas.assemblers.QuestionModelAssembler;
import com.learning.be.api.hateoas.assemblers.UserModelAssembler;
import com.learning.be.business.dto.AnswerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "answer")
@Relation(collectionRelation = "answers")
@JsonInclude(value = Include.NON_NULL)
public class AnswerModel extends RepresentationModel<AnswerModel> {

	private Long id;
	
	private Date timestamp;
	
	private String answer;
	
	private Boolean correct;
	
	private QuestionModel question;
	
	private Set<UserModel> usersThatChoseThisAnswer;
	
}
