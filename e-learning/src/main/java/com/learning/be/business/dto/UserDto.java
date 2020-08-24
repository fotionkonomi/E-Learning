package com.learning.be.business.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learning.be.business.dto.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseClassDto implements UserDetails {

	private static final long serialVersionUID = -6200896515769546024L;

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
	
	@NotEmpty
	private Date dateOfBirth;
	
	private Date dateRegistered;
	
	private BranchDto branch;
	
	private RoleDto role;
	
	private Set<CourseDto> myStudentCourses = new HashSet<>();
	
	private List<CourseDto> myProfessorCourses = new ArrayList<>();

	private Set<AnswerDto> myAnswers = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
