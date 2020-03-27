package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.University;

@Repository
public interface UniversityRepository extends ELearningRepository<University, Long>  {

}
