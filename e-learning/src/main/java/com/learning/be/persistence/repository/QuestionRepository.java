package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Question;

@Repository
public interface QuestionRepository extends ELearningRepository<Question, Long> {

}
