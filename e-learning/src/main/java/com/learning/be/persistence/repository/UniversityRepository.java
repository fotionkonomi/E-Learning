package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.University;

@Repository
public interface UniversityRepository extends ELearningRepository<University, Long>  {

}
