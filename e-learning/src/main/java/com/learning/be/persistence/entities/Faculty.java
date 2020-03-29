package com.learning.be.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "faculty")
@Data
@ToString( exclude = { "studentsAndProfessors" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "studentsAndProfessors" } )
public class Faculty extends BaseClass {

	@Column(name = "name_faculty", nullable = false, length = 100)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "university_id", referencedColumnName = "id")
	private University university;
	
	@OneToMany(mappedBy = "faculty")
	private List<User> studentsAndProfessors = new ArrayList<>();
		
}
