package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.Answer;

@Repository
public interface AnswerRepository extends ELearningRepository<Answer, Long> {

}
