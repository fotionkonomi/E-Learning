package com.learning.be.business.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.learning.be.business.dto.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = UserDto.class)
public class UserDto extends BaseClassDto {

	@Size(max = 50)
	@NotEmpty
	private String firstName;
	
	@Size(max = 50)
	@NotEmpty
	private String lastName;
	
	@Size(max = 50)
	@NotEmpty
	private String username;
	
	@Size(max = 255)
	@NotEmpty
	private String password;
	
	private GenderEnum gender;
	
	@Size(max = 100)
	@NotEmpty
	private String email;
	
	private Date dateOfBirth;
	
	private Date dateRegistered;
	
	private BranchDto branch;
	
	private RoleDto role;
	
	private Set<CourseDto> myStudentCourses = new HashSet<>();
	
	private List<CourseDto> myProfessorCourses = new ArrayList<>();

	private Set<AnswerDto> myAnswers = new HashSet<>();
}
