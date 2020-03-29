package com.learning.be.persistence.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "course")
@Data
@ToString( exclude = { "tests", "students" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "tests", "students" })
public class Course extends BaseClass {

	@Column(name = "name_course", nullable = false, length = 100)
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Test> tests = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "id")
	private User professor;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "course_student", joinColumns = { @JoinColumn(name = "id_course") }, inverseJoinColumns = {
			@JoinColumn(name = "id_student") })
	private Set<User> students = new HashSet<>();
}
