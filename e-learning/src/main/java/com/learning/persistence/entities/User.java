package com.learning.persistence.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString( exclude = { "myStudentCourses", "myProfessorCourses", "myAnswers"  } )
@EqualsAndHashCode(callSuper = true, exclude = { "myStudentCourses", "myProfessorCourses", "myAnswers"  })
public class User extends BaseClass {

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "date_of_birth", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Column(name = "date_registered", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistered;
	
//	@Column(name = "date_edited", nullable = false, columnDefinition = "DATETIME")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date dateEdited;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToMany(mappedBy = "students")
	private Set<Course> myStudentCourses = new HashSet<>();
	
	@OneToMany(mappedBy = "professor")
	private List<Course> myProfessorCourses = new ArrayList<>();

	@ManyToMany(mappedBy = "usersThatChoseThisAnswer")
	private Set<Answer> myAnswers = new HashSet<>();
}
