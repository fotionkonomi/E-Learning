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
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "branch", uniqueConstraints = { @UniqueConstraint(columnNames = { "name_branch", "faculty_id" }) })
@Data
@ToString(exclude = { "students" })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "students" })
public class Branch extends BaseClass {

	@Column(name = "name_branch", nullable = false, length = 100)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;

	@OneToMany(mappedBy = "branch")
	private List<User> students = new ArrayList<>();

}
