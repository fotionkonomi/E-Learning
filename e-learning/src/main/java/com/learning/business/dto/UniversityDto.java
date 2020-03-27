package com.learning.business.dto;

import java.util.ArrayList;
import java.util.List;

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
public class UniversityDto extends BaseClassDto {

	@Size(max = 100)
	@NotEmpty
	private String name;

	@Size(max = 65535)
	@NotEmpty
	private String address;
	
	private List<FacultyDto> faculties = new ArrayList<>();
}
