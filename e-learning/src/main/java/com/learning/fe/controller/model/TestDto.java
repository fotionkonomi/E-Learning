package com.learning.fe.controller.model;

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
public class TestDto extends BaseClassModel {

	@Size(max = 50)
	@NotEmpty
	private String name;
	
	private CourseDto course;
	
	private Set<QuestionDto> questions = new HashSet<>();
	
}
