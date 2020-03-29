package com.learning.be.persistence.entities;

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

import com.learning.be.persistence.enums.QuestionDifficulty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "question")
@Data
@ToString( exclude = { "answers", "tests" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true , exclude = { "answers", "tests" })
public class Question extends BaseClass {

	@Column(name = "question", nullable = false, columnDefinition = "TEXT", length = 65535)
	private String question;
	
	@Enumerated(EnumType.ORDINAL)
	private QuestionDifficulty difficulty;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answers = new ArrayList<>();
	
	@Column(name = "correct")
	private Boolean correct;
	
	@ManyToMany(mappedBy = "questions")
	private Set<Test> tests = new HashSet<>();
	
	private Long numberOfPoints;
}
