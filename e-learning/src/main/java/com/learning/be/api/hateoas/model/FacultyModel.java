package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonRootName(value = "faculty")
@Relation(collectionRelation = "faculties")
@JsonInclude(value = Include.NON_NULL)
public class FacultyModel extends RepresentationModel<FacultyModel> {

	private Long id;
	
	private Date timestamp;
	
	private String name;
	
	private UniversityModel university;
	
	private List<UserModel> studentsAndProfessors;
	
}
