package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.Test;

@Repository
public interface TestRepository extends ELearningRepository<Test, Long> {

}
