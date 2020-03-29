package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Answer;

@Repository
public interface AnswerRepository extends ELearningRepository<Answer, Long> {

}
