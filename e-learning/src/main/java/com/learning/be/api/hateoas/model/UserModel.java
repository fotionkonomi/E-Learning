package com.learning.be.api.hateoas.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.learning.be.business.dto.RoleDto;
import com.learning.be.business.dto.enums.GenderEnum;
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
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@JsonInclude(value = Include.NON_NULL)
public class UserModel extends RepresentationModel<UserModel> {

	private Long id;

	private Date timestamp;

	private String firstName;

	private String lastName;

	private String username;

//	private String password;

	private GenderEnum gender;

	private String email;

	private Date dateOfBirth;

	private Date dateRegistered;

	private FacultyModel faculty;

	private RoleDto role;

	private Set<CourseModel> myStudentCourses;

	private List<CourseModel> myProfessorCourses;

	private Set<AnswerModel> myAnswers;

}
