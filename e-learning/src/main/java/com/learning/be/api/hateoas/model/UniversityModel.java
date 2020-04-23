package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.List;

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
@JsonRootName(value = "university")
@Relation(collectionRelation = "universities")
@JsonInclude(value = Include.NON_NULL)
public class UniversityModel extends RepresentationModel<UniversityModel> {

	private Long id;

	private Date timestamp;

	private String name;

	private String address;

	private List<FacultyModel> faculties;

}
