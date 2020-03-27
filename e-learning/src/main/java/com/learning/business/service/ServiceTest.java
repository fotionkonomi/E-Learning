package com.learning.business.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.persistence.entities.Answer;
import com.learning.persistence.entities.Faculty;
import com.learning.persistence.entities.Question;
import com.learning.persistence.entities.Test;
import com.learning.persistence.entities.University;
import com.learning.persistence.entities.User;

@Component
public class ServiceTest {

	@Autowired
	private ModelMapper modelMapper;
	
	public int faculty() {
		University university = new University();
		university.setId(1L);
		university.setTimestamp(new Date());
		university.setName("UPT");
		university.setAddress("Nene Tereza");
		
		User user = new User();
		user.setFirstName("Fotion");
		user.setLastName("Konomi");
		user.setEmail("kfotjon@gmail.com");
	
		
		Faculty faculty = new Faculty();
		faculty.setId(2L);
		faculty.setName("FTI");
		faculty.setUniversity(university);
		faculty.setTimestamp(new Date());
		faculty.getStudentsAndProfessors().addAll(Arrays.asList(user, user));
		
		Test test = new Test();
		
		Question questionEDuhur1 = new Question();
		Question questionEDuhur2 = new Question();
		Question questionEDuhur3 = new Question();
		Question questionJO1 = new Question();
		Question questionJO2 = new Question();
		Question questionJO3 = new Question();
		questionJO1.setQuestion("NUUUUK Eshte pyetje e duhur");
		questionJO2.setQuestion("NUUUUK Eshte pyetje e duhur");
		questionJO3.setQuestion("NUUUUK Eshte pyetje e duhur");

		questionEDuhur1.setQuestion("Eshte pyetje e duhur");
		questionEDuhur2.setQuestion("Eshte pyetje e duhur2");
		questionEDuhur3.setQuestion("Eshte pyetje e duhur3");
		
		Answer answerPerQ1 = new Answer();
		answerPerQ1.setAnswerOfQuestion("Pergjigje e pare e Q1");
		answerPerQ1.setQuestion(questionEDuhur1);
		Answer answerPerQ2 = new Answer();
		answerPerQ2.setAnswerOfQuestion("Pergjigje e dyte e Q1");
		answerPerQ2.setQuestion(questionEDuhur1);
		Answer answerPerQ3 = new Answer();
		answerPerQ3.setAnswerOfQuestion("Pergjigje e pare e Q2");
		answerPerQ3.setQuestion(questionEDuhur2);
		
		Answer answerPerJO1 = new Answer();
		answerPerJO1.setAnswerOfQuestion("Pergjigje e pare e JOQ1");
		answerPerJO1.setQuestion(questionJO1);
		
		questionEDuhur1.setAnswers(Arrays.asList(answerPerQ1, answerPerQ2, answerPerQ3));

		user.getMyAnswers().add(answerPerQ1);
		user.getMyAnswers().add(answerPerQ2);
		user.getMyAnswers().add(answerPerJO1);
		

		questionEDuhur1.setTests(new HashSet<Test>(Arrays.asList(test)));
		test.setName("Testi i duhur");
		test.setQuestions(new HashSet<Question>(Arrays.asList(questionEDuhur1, questionEDuhur2, questionEDuhur3)));
		
		Test testJo = new Test();
		testJo.setName("Testi jo i duhur");
		testJo.setQuestions(new HashSet<Question>(Arrays.asList(questionJO1, questionJO2)));
		
		Set<Answer> set = user.getMyAnswers().stream().filter(a -> a.getQuestion().getTests().stream().anyMatch(d -> d.equals(test))).collect(Collectors.toSet());
		
		for(Answer answer : set) {
			System.out.println(answer.getAnswerOfQuestion());
		}
		
//		return user.getMyAnswers().size();
		return user.getMyAnswers().stream().filter(a -> a.getQuestion().getTests().stream().anyMatch(d -> d.equals(test))).collect(Collectors.toSet()).size();
		
		//return modelMapper.map(faculty, FacultyDto.class);
		
	}
}
