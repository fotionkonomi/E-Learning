package com.learning.persistence.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.learning.persistence.enums.QuestionDifficulty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Question extends BaseClass {

	private String question;
	
	@Enumerated(EnumType.ORDINAL)
	private QuestionDifficulty difficulty;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answers = new ArrayList<>();
	
	@Column(name = "correct", nullable = false)
	private Boolean correct;
	
	@ManyToMany(mappedBy = "questions")
	private Set<Test> tests = new HashSet<>();
	
	private Long numberOfPoints;
}
