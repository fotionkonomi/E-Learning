package com.learning.business.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseClassDto {

	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Date dateOfBirth;
	
	private Date dateRegistered;
	
	private FacultyDto faculty;
	
	private RoleDto role;
}
