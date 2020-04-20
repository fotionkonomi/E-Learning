package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

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
@JsonRootName(value = "test")
@Relation(collectionRelation = "tests")
@JsonInclude(value = Include.NON_NULL)
public class TestModel extends RepresentationModel<TestModel> {

	private Long id;
	
	private Date timestamp;
	
	private String name;
	
	private CourseModel course;
	
	private Set<QuestionModel> questions;
	
}
