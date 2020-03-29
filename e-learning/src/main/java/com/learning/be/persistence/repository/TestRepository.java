package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Test;

@Repository
public interface TestRepository extends ELearningRepository<Test, Long> {

}
