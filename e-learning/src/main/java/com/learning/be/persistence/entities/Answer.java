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
@Table(name = "answer")
@Data
@ToString(exclude = { "usersThatChoseThisAnswer" })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "usersThatChoseThisAnswer" })
public class Answer extends BaseClass {

	@Column(name = "answer", nullable = false, columnDefinition = "TEXT", length = 65535)
	private String answerOfQuestion;

	@Column(name = "correct", nullable = false)
	private Boolean correct;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Question question;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "answer_student", joinColumns = { @JoinColumn(name = "id_answer") }, inverseJoinColumns = {
			@JoinColumn(name = "id_user") })
	private Set<User> usersThatChoseThisAnswer = new HashSet<>();

}
