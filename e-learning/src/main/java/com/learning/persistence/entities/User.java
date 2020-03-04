package com.learning.persistence.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseClass {

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "date_of_birth", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Column(name = "date_registered", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistered;
	
	@Column(name = "date_edited", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEdited;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Faculty faculty;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Role role;
}
