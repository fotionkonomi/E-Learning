package com.learning.be.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString( exclude = { "answers" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true , exclude = { "answers" })
public class Question extends BaseClass {

	@Column(name = "question", nullable = false, columnDefinition = "TEXT", length = 65535)
	private String question;
	
	@Enumerated(EnumType.ORDINAL)
	private QuestionDifficulty difficulty;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answers = new ArrayList<>();
	
	@Column(name = "correct")
	private Boolean correct;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id", referencedColumnName = "id")
	private Test test;
	
	private Long numberOfPoints;
}
