package com.learning.be.business.dto;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "branches" })
@ToString(exclude = { "branches" })
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = FacultyDto.class)
public class FacultyDto extends BaseClassDto {

	@Size(max = 100)
	@NotEmpty
	private String name;
	
	@NotNull
	@JsonBackReference
	private UniversityDto university;
	
	@JsonManagedReference
	private List<BranchDto> branches = new ArrayList<>();

	
}
