package com.learning.be.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "test")
@Data
@ToString( exclude = { "questions" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "questions" })
public class Test extends BaseClass {

	@Column(name = "name_test", nullable = false, length = 50)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "tests_questions", joinColumns = { @JoinColumn(name = "id_test") }, inverseJoinColumns = {
			@JoinColumn(name = "id_question") })
	private Set<Question> questions = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

}
