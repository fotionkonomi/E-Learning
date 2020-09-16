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
@Table(name = "test")
@Data
@ToString(exclude = { "questions" })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "questions" })
public class Test extends BaseClass {

	@Column(name = "name_test", nullable = false, length = 50)
	private String name;

	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
	private List<Question> questions = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

}
