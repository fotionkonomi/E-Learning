package com.learning.business.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class CourseDto extends BaseClassDto {

	@Size(max = 100)
	@NotEmpty
	private String name;
	
	private UserDto professor;
	
	private List<TestDto> tests = new ArrayList<>();
	
	private Set<UserDto> students = new HashSet<>();
}
